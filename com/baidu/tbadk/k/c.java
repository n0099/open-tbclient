package com.baidu.tbadk.k;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.a.a.a implements Runnable {
    public static String bzS = "logcat ";
    private static Map<String, b> bzU = new HashMap();
    private Process bzP;
    private InputStream bzQ;
    private OutputStream bzR;
    private a bzT;

    public static void a(String str, b bVar) {
        bzU.put(str, bVar);
        bzS += " -s " + str;
    }

    public void hb(String str) {
        String[] split = str.split("\n");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < split.length) {
                Iterator<Map.Entry<String, b>> it = bzU.entrySet().iterator();
                while (true) {
                    if (it.hasNext()) {
                        Map.Entry<String, b> next = it.next();
                        if (split[i2].contains(next.getKey().toString())) {
                            next.getValue().ha(split[i2]);
                            break;
                        }
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
            this.bzP = Runtime.getRuntime().exec(bzS);
            this.bzR = this.bzP.getOutputStream();
            this.bzQ = this.bzP.getInputStream();
            Oc();
            this.bzR.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void Oc() throws FileNotFoundException {
        this.bzT = new a(this.bzQ);
        this.bzT.start();
    }

    @Override // com.baidu.adp.a.a.a
    public void stop() {
        super.stop();
        try {
            if (this.bzP != null) {
                this.bzP.destroy();
            }
            if (this.bzT != null) {
                this.bzT.finish();
            }
            if (this.bzQ != null) {
                this.bzQ.close();
            }
            if (this.bzR != null) {
                this.bzR.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends Thread {
        private boolean bzV = false;
        private InputStream in;

        public a(InputStream inputStream) {
            this.in = inputStream;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            int read;
            byte[] bArr = new byte[8192];
            while (!this.bzV && (read = this.in.read(bArr)) != -1) {
                try {
                    String str = new String(bArr, 0, read);
                    if (str != null) {
                        c.this.hb(str);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    return;
                }
            }
        }

        public synchronized void finish() {
            this.bzV = true;
        }
    }
}
