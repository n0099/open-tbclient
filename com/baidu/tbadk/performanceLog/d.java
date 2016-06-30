package com.baidu.tbadk.performanceLog;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.a.a.a implements Runnable {
    private a axA;
    private Process axw;
    private InputStream axx;
    private OutputStream axy;
    public static String axz = "logcat ";
    private static Map<String, c> axB = new HashMap();

    public static void a(String str, c cVar) {
        axB.put(str, cVar);
        axz = String.valueOf(axz) + " -s " + str;
    }

    public void ge(String str) {
        String[] split = str.split("\n");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < split.length) {
                Iterator<Map.Entry<String, c>> it = axB.entrySet().iterator();
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
            this.axw = Runtime.getRuntime().exec(axz);
            this.axy = this.axw.getOutputStream();
            this.axx = this.axw.getInputStream();
            EC();
            this.axy.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void EC() {
        this.axA = new a(this.axx);
        this.axA.start();
    }

    @Override // com.baidu.adp.a.a.a
    public void stop() {
        super.stop();
        try {
            if (this.axw != null) {
                this.axw.destroy();
            }
            if (this.axA != null) {
                this.axA.finish();
            }
            if (this.axx != null) {
                this.axx.close();
            }
            if (this.axy != null) {
                this.axy.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends Thread {
        private boolean axC = false;
        private InputStream in;

        public a(InputStream inputStream) {
            this.in = inputStream;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            int read;
            byte[] bArr = new byte[8192];
            while (!this.axC && (read = this.in.read(bArr)) != -1) {
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
            this.axC = true;
        }
    }
}
