package com.icss.ui;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PressTest {

	public static void main(String[] args) {
		ExecutorService service = Executors.newCachedThreadPool();
		for (int i = 0; i < 50; i++) {
			service.execute(new Thread() {
				public void run() {
					try {
						long start = System.currentTimeMillis();
						URL url = new URL("http://localhost:8080/Dangdang/MainSvl"); 
						HttpURLConnection conn = (HttpURLConnection) url.openConnection();
						conn.setRequestMethod("GET");
						conn.setConnectTimeout(15000);		
						conn.connect();
						if (conn.getResponseCode() == 200) {
							long past = System.currentTimeMillis() - start;
							System.out.println(Thread.currentThread().getId() + "-ÇëÇó³É¹¦..." + past);
						}else {
							System.out.println(conn.getResponseCode()+"************");
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
	}

}
