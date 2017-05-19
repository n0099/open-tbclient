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
    public static String aFQ = "logcat ";
    private static Map<String, c> aFS = new HashMap();
    private Process aFN;
    private InputStream aFO;
    private OutputStream aFP;
    private a aFR;

    public static void a(String str, c cVar) {
        aFS.put(str, cVar);
        aFQ = String.valueOf(aFQ) + " -s " + str;
    }

    public void fW(String str) {
        String[] split = str.split("\n");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < split.length) {
                Iterator<Map.Entry<String, c>> it = aFS.entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Map.Entry<String, c> next = it.next();
                    if (split[i2].contains(next.getKey().toString())) {
                        next.getValue().fV(split[i2]);
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
            this.aFN = Runtime.getRuntime().exec(aFQ);
            this.aFP = this.aFN.getOutputStream();
            this.aFO = this.aFN.getInputStream();
            Fq();
            this.aFP.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void Fq() throws FileNotFoundException {
        this.aFR = new a(this.aFO);
        this.aFR.start();
    }

    @Override // com.baidu.adp.a.a.a
    public void stop() {
        super.stop();
        try {
            if (this.aFN != null) {
                this.aFN.destroy();
            }
            if (this.aFR != null) {
                this.aFR.finish();
            }
            if (this.aFO != null) {
                this.aFO.close();
            }
            if (this.aFP != null) {
                this.aFP.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends Thread {
        private boolean aFT = false;
        private InputStream in;

        public a(InputStream inputStream) {
            this.in = inputStream;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            int read;
            byte[] bArr = new byte[8192];
            while (!this.aFT && (read = this.in.read(bArr)) != -1) {
                try {
                    String str = new String(bArr, 0, read);
                    if (str != null) {
                        d.this.fW(str);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    return;
                }
            }
        }

        public synchronized void finish() {
            this.aFT = true;
        }
    }
}
