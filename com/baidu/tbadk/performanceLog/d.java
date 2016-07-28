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
    public static String ayp = "logcat ";
    private static Map<String, c> ayr = new HashMap();
    private Process aym;
    private InputStream ayn;
    private OutputStream ayo;
    private a ayq;

    public static void a(String str, c cVar) {
        ayr.put(str, cVar);
        ayp = String.valueOf(ayp) + " -s " + str;
    }

    public void gc(String str) {
        String[] split = str.split("\n");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < split.length) {
                Iterator<Map.Entry<String, c>> it = ayr.entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Map.Entry<String, c> next = it.next();
                    if (split[i2].contains(next.getKey().toString())) {
                        next.getValue().gb(split[i2]);
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
            this.aym = Runtime.getRuntime().exec(ayp);
            this.ayo = this.aym.getOutputStream();
            this.ayn = this.aym.getInputStream();
            EB();
            this.ayo.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void EB() throws FileNotFoundException {
        this.ayq = new a(this.ayn);
        this.ayq.start();
    }

    @Override // com.baidu.adp.a.a.a
    public void stop() {
        super.stop();
        try {
            if (this.aym != null) {
                this.aym.destroy();
            }
            if (this.ayq != null) {
                this.ayq.finish();
            }
            if (this.ayn != null) {
                this.ayn.close();
            }
            if (this.ayo != null) {
                this.ayo.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends Thread {
        private boolean ays = false;
        private InputStream in;

        public a(InputStream inputStream) {
            this.in = inputStream;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            int read;
            byte[] bArr = new byte[8192];
            while (!this.ays && (read = this.in.read(bArr)) != -1) {
                try {
                    String str = new String(bArr, 0, read);
                    if (str != null) {
                        d.this.gc(str);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    return;
                }
            }
        }

        public synchronized void finish() {
            this.ays = true;
        }
    }
}
