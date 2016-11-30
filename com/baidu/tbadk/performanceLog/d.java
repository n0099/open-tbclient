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
    public static String aBQ = "logcat ";
    private static Map<String, c> aBS = new HashMap();
    private Process aBN;
    private InputStream aBO;
    private OutputStream aBP;
    private a aBR;

    public static void a(String str, c cVar) {
        aBS.put(str, cVar);
        aBQ = String.valueOf(aBQ) + " -s " + str;
    }

    public void gm(String str) {
        String[] split = str.split("\n");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < split.length) {
                Iterator<Map.Entry<String, c>> it = aBS.entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Map.Entry<String, c> next = it.next();
                    if (split[i2].contains(next.getKey().toString())) {
                        next.getValue().gl(split[i2]);
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
            this.aBN = Runtime.getRuntime().exec(aBQ);
            this.aBP = this.aBN.getOutputStream();
            this.aBO = this.aBN.getInputStream();
            Ga();
            this.aBP.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void Ga() throws FileNotFoundException {
        this.aBR = new a(this.aBO);
        this.aBR.start();
    }

    @Override // com.baidu.adp.a.a.a
    public void stop() {
        super.stop();
        try {
            if (this.aBN != null) {
                this.aBN.destroy();
            }
            if (this.aBR != null) {
                this.aBR.finish();
            }
            if (this.aBO != null) {
                this.aBO.close();
            }
            if (this.aBP != null) {
                this.aBP.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends Thread {
        private boolean aBT = false;
        private InputStream in;

        public a(InputStream inputStream) {
            this.in = inputStream;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            int read;
            byte[] bArr = new byte[8192];
            while (!this.aBT && (read = this.in.read(bArr)) != -1) {
                try {
                    String str = new String(bArr, 0, read);
                    if (str != null) {
                        d.this.gm(str);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    return;
                }
            }
        }

        public synchronized void finish() {
            this.aBT = true;
        }
    }
}
