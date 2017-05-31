package com.baidu.tbadk.j;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.a.a.a implements Runnable {
    public static String aFD = "logcat ";
    private static Map<String, c> aFF = new HashMap();
    private Process aFA;
    private InputStream aFB;
    private OutputStream aFC;
    private a aFE;

    public static void a(String str, c cVar) {
        aFF.put(str, cVar);
        aFD = String.valueOf(aFD) + " -s " + str;
    }

    public void fV(String str) {
        String[] split = str.split("\n");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < split.length) {
                Iterator<Map.Entry<String, c>> it = aFF.entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Map.Entry<String, c> next = it.next();
                    if (split[i2].contains(next.getKey().toString())) {
                        next.getValue().fU(split[i2]);
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
            this.aFA = Runtime.getRuntime().exec(aFD);
            this.aFC = this.aFA.getOutputStream();
            this.aFB = this.aFA.getInputStream();
            Fk();
            this.aFC.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void Fk() throws FileNotFoundException {
        this.aFE = new a(this.aFB);
        this.aFE.start();
    }

    @Override // com.baidu.adp.a.a.a
    public void stop() {
        super.stop();
        try {
            if (this.aFA != null) {
                this.aFA.destroy();
            }
            if (this.aFE != null) {
                this.aFE.finish();
            }
            if (this.aFB != null) {
                this.aFB.close();
            }
            if (this.aFC != null) {
                this.aFC.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends Thread {
        private boolean aFG = false;
        private InputStream in;

        public a(InputStream inputStream) {
            this.in = inputStream;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            int read;
            byte[] bArr = new byte[8192];
            while (!this.aFG && (read = this.in.read(bArr)) != -1) {
                try {
                    String str = new String(bArr, 0, read);
                    if (str != null) {
                        d.this.fV(str);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    return;
                }
            }
        }

        public synchronized void finish() {
            this.aFG = true;
        }
    }
}
