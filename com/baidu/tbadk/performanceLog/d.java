package com.baidu.tbadk.performanceLog;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.a.a.a implements Runnable {
    public static String aAc = "logcat ";
    private static Map<String, c> aAe = new HashMap();
    private InputStream aAa;
    private OutputStream aAb;
    private a aAd;
    private Process azZ;

    public static void a(String str, c cVar) {
        aAe.put(str, cVar);
        aAc = String.valueOf(aAc) + " -s " + str;
    }

    public void ge(String str) {
        String[] split = str.split("\n");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < split.length) {
                Iterator<Map.Entry<String, c>> it = aAe.entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Map.Entry<String, c> next = it.next();
                    if (split[i2].contains(next.getKey().toString())) {
                        next.getValue().gd(split[i2]);
                        break;
                    }
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        super.start();
        try {
            Runtime.getRuntime().exec("logcat -c");
            this.azZ = Runtime.getRuntime().exec(aAc);
            this.aAb = this.azZ.getOutputStream();
            this.aAa = this.azZ.getInputStream();
            Fu();
            this.aAb.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void Fu() throws FileNotFoundException {
        this.aAd = new a(this.aAa);
        this.aAd.start();
    }

    @Override // com.baidu.adp.a.a.a
    public void stop() {
        super.stop();
        try {
            if (this.azZ != null) {
                this.azZ.destroy();
            }
            if (this.aAd != null) {
                this.aAd.finish();
            }
            if (this.aAa != null) {
                this.aAa.close();
            }
            if (this.aAb != null) {
                this.aAb.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends Thread {
        private boolean aAf = false;
        private InputStream in;

        public a(InputStream inputStream) {
            this.in = inputStream;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            int read;
            byte[] bArr = new byte[8192];
            while (!this.aAf && (read = this.in.read(bArr)) != -1) {
                try {
                    String str = new String(bArr, 0, read);
                    if (str != null) {
                        d.this.ge(str);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    return;
                }
            }
        }

        public synchronized void finish() {
            this.aAf = true;
        }
    }
}
