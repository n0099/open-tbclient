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
    public static String aBw = "logcat ";
    private static Map<String, c> aBy = new HashMap();
    private Process aBt;
    private InputStream aBu;
    private OutputStream aBv;
    private a aBx;

    public static void a(String str, c cVar) {
        aBy.put(str, cVar);
        aBw = String.valueOf(aBw) + " -s " + str;
    }

    public void gf(String str) {
        String[] split = str.split("\n");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < split.length) {
                Iterator<Map.Entry<String, c>> it = aBy.entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Map.Entry<String, c> next = it.next();
                    if (split[i2].contains(next.getKey().toString())) {
                        next.getValue().ge(split[i2]);
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
            this.aBt = Runtime.getRuntime().exec(aBw);
            this.aBv = this.aBt.getOutputStream();
            this.aBu = this.aBt.getInputStream();
            FV();
            this.aBv.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void FV() throws FileNotFoundException {
        this.aBx = new a(this.aBu);
        this.aBx.start();
    }

    @Override // com.baidu.adp.a.a.a
    public void stop() {
        super.stop();
        try {
            if (this.aBt != null) {
                this.aBt.destroy();
            }
            if (this.aBx != null) {
                this.aBx.finish();
            }
            if (this.aBu != null) {
                this.aBu.close();
            }
            if (this.aBv != null) {
                this.aBv.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends Thread {
        private boolean aBz = false;
        private InputStream in;

        public a(InputStream inputStream) {
            this.in = inputStream;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            int read;
            byte[] bArr = new byte[8192];
            while (!this.aBz && (read = this.in.read(bArr)) != -1) {
                try {
                    String str = new String(bArr, 0, read);
                    if (str != null) {
                        d.this.gf(str);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    return;
                }
            }
        }

        public synchronized void finish() {
            this.aBz = true;
        }
    }
}
