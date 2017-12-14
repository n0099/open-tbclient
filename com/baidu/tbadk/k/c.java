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
    public static String aJC = "logcat ";
    private static Map<String, b> aJE = new HashMap();
    private InputStream aJA;
    private OutputStream aJB;
    private a aJD;
    private Process aJz;

    public static void a(String str, b bVar) {
        aJE.put(str, bVar);
        aJC += " -s " + str;
    }

    public void gG(String str) {
        String[] split = str.split("\n");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < split.length) {
                Iterator<Map.Entry<String, b>> it = aJE.entrySet().iterator();
                while (true) {
                    if (it.hasNext()) {
                        Map.Entry<String, b> next = it.next();
                        if (split[i2].contains(next.getKey().toString())) {
                            next.getValue().gF(split[i2]);
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
            this.aJz = Runtime.getRuntime().exec(aJC);
            this.aJB = this.aJz.getOutputStream();
            this.aJA = this.aJz.getInputStream();
            Gh();
            this.aJB.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void Gh() throws FileNotFoundException {
        this.aJD = new a(this.aJA);
        this.aJD.start();
    }

    @Override // com.baidu.adp.a.a.a
    public void stop() {
        super.stop();
        try {
            if (this.aJz != null) {
                this.aJz.destroy();
            }
            if (this.aJD != null) {
                this.aJD.finish();
            }
            if (this.aJA != null) {
                this.aJA.close();
            }
            if (this.aJB != null) {
                this.aJB.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends Thread {
        private boolean aJF = false;
        private InputStream in;

        public a(InputStream inputStream) {
            this.in = inputStream;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            int read;
            byte[] bArr = new byte[8192];
            while (!this.aJF && (read = this.in.read(bArr)) != -1) {
                try {
                    String str = new String(bArr, 0, read);
                    if (str != null) {
                        c.this.gG(str);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    return;
                }
            }
        }

        public synchronized void finish() {
            this.aJF = true;
        }
    }
}
