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
    public static String aFM = "logcat ";
    private static Map<String, c> aFO = new HashMap();
    private Process aFJ;
    private InputStream aFK;
    private OutputStream aFL;
    private a aFN;

    public static void a(String str, c cVar) {
        aFO.put(str, cVar);
        aFM = String.valueOf(aFM) + " -s " + str;
    }

    public void fZ(String str) {
        String[] split = str.split("\n");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < split.length) {
                Iterator<Map.Entry<String, c>> it = aFO.entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Map.Entry<String, c> next = it.next();
                    if (split[i2].contains(next.getKey().toString())) {
                        next.getValue().fY(split[i2]);
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
            this.aFJ = Runtime.getRuntime().exec(aFM);
            this.aFL = this.aFJ.getOutputStream();
            this.aFK = this.aFJ.getInputStream();
            Gm();
            this.aFL.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void Gm() throws FileNotFoundException {
        this.aFN = new a(this.aFK);
        this.aFN.start();
    }

    @Override // com.baidu.adp.a.a.a
    public void stop() {
        super.stop();
        try {
            if (this.aFJ != null) {
                this.aFJ.destroy();
            }
            if (this.aFN != null) {
                this.aFN.finish();
            }
            if (this.aFK != null) {
                this.aFK.close();
            }
            if (this.aFL != null) {
                this.aFL.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends Thread {
        private boolean aFP = false;
        private InputStream in;

        public a(InputStream inputStream) {
            this.in = inputStream;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            int read;
            byte[] bArr = new byte[8192];
            while (!this.aFP && (read = this.in.read(bArr)) != -1) {
                try {
                    String str = new String(bArr, 0, read);
                    if (str != null) {
                        d.this.fZ(str);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    return;
                }
            }
        }

        public synchronized void finish() {
            this.aFP = true;
        }
    }
}
