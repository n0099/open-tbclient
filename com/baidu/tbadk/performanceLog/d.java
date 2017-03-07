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
    public static String aFu = "logcat ";
    private static Map<String, c> aFw = new HashMap();
    private Process aFr;
    private InputStream aFs;
    private OutputStream aFt;
    private a aFv;

    public static void a(String str, c cVar) {
        aFw.put(str, cVar);
        aFu = String.valueOf(aFu) + " -s " + str;
    }

    public void fT(String str) {
        String[] split = str.split("\n");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < split.length) {
                Iterator<Map.Entry<String, c>> it = aFw.entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Map.Entry<String, c> next = it.next();
                    if (split[i2].contains(next.getKey().toString())) {
                        next.getValue().fS(split[i2]);
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
            this.aFr = Runtime.getRuntime().exec(aFu);
            this.aFt = this.aFr.getOutputStream();
            this.aFs = this.aFr.getInputStream();
            FO();
            this.aFt.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void FO() throws FileNotFoundException {
        this.aFv = new a(this.aFs);
        this.aFv.start();
    }

    @Override // com.baidu.adp.a.a.a
    public void stop() {
        super.stop();
        try {
            if (this.aFr != null) {
                this.aFr.destroy();
            }
            if (this.aFv != null) {
                this.aFv.finish();
            }
            if (this.aFs != null) {
                this.aFs.close();
            }
            if (this.aFt != null) {
                this.aFt.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends Thread {
        private boolean aFx = false;
        private InputStream in;

        public a(InputStream inputStream) {
            this.in = inputStream;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            int read;
            byte[] bArr = new byte[8192];
            while (!this.aFx && (read = this.in.read(bArr)) != -1) {
                try {
                    String str = new String(bArr, 0, read);
                    if (str != null) {
                        d.this.fT(str);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    return;
                }
            }
        }

        public synchronized void finish() {
            this.aFx = true;
        }
    }
}
