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
    public static String aAZ = "logcat ";
    private static Map<String, c> aBb = new HashMap();
    private Process aAW;
    private InputStream aAX;
    private OutputStream aAY;
    private a aBa;

    public static void a(String str, c cVar) {
        aBb.put(str, cVar);
        aAZ = String.valueOf(aAZ) + " -s " + str;
    }

    public void gj(String str) {
        String[] split = str.split("\n");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < split.length) {
                Iterator<Map.Entry<String, c>> it = aBb.entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Map.Entry<String, c> next = it.next();
                    if (split[i2].contains(next.getKey().toString())) {
                        next.getValue().gi(split[i2]);
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
            this.aAW = Runtime.getRuntime().exec(aAZ);
            this.aAY = this.aAW.getOutputStream();
            this.aAX = this.aAW.getInputStream();
            FU();
            this.aAY.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void FU() throws FileNotFoundException {
        this.aBa = new a(this.aAX);
        this.aBa.start();
    }

    @Override // com.baidu.adp.a.a.a
    public void stop() {
        super.stop();
        try {
            if (this.aAW != null) {
                this.aAW.destroy();
            }
            if (this.aBa != null) {
                this.aBa.finish();
            }
            if (this.aAX != null) {
                this.aAX.close();
            }
            if (this.aAY != null) {
                this.aAY.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends Thread {
        private boolean aBc = false;
        private InputStream in;

        public a(InputStream inputStream) {
            this.in = inputStream;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            int read;
            byte[] bArr = new byte[8192];
            while (!this.aBc && (read = this.in.read(bArr)) != -1) {
                try {
                    String str = new String(bArr, 0, read);
                    if (str != null) {
                        d.this.gj(str);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    return;
                }
            }
        }

        public synchronized void finish() {
            this.aBc = true;
        }
    }
}
