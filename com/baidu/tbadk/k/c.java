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
    public static String bxL = "logcat ";
    private static Map<String, b> bxN = new HashMap();
    private Process bxI;
    private InputStream bxJ;
    private OutputStream bxK;
    private a bxM;

    public static void a(String str, b bVar) {
        bxN.put(str, bVar);
        bxL += " -s " + str;
    }

    public void gS(String str) {
        String[] split = str.split("\n");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < split.length) {
                Iterator<Map.Entry<String, b>> it = bxN.entrySet().iterator();
                while (true) {
                    if (it.hasNext()) {
                        Map.Entry<String, b> next = it.next();
                        if (split[i2].contains(next.getKey().toString())) {
                            next.getValue().gR(split[i2]);
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
            this.bxI = Runtime.getRuntime().exec(bxL);
            this.bxK = this.bxI.getOutputStream();
            this.bxJ = this.bxI.getInputStream();
            Nw();
            this.bxK.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void Nw() throws FileNotFoundException {
        this.bxM = new a(this.bxJ);
        this.bxM.start();
    }

    @Override // com.baidu.adp.a.a.a
    public void stop() {
        super.stop();
        try {
            if (this.bxI != null) {
                this.bxI.destroy();
            }
            if (this.bxM != null) {
                this.bxM.finish();
            }
            if (this.bxJ != null) {
                this.bxJ.close();
            }
            if (this.bxK != null) {
                this.bxK.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends Thread {
        private boolean bxO = false;
        private InputStream in;

        public a(InputStream inputStream) {
            this.in = inputStream;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            int read;
            byte[] bArr = new byte[8192];
            while (!this.bxO && (read = this.in.read(bArr)) != -1) {
                try {
                    String str = new String(bArr, 0, read);
                    if (str != null) {
                        c.this.gS(str);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    return;
                }
            }
        }

        public synchronized void finish() {
            this.bxO = true;
        }
    }
}
