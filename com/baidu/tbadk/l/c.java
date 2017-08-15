package com.baidu.tbadk.l;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.a.a.a implements Runnable {
    public static String aJp = "logcat ";
    private static Map<String, b> aJr = new HashMap();
    private Process aJm;
    private InputStream aJn;
    private OutputStream aJo;
    private a aJq;

    public static void a(String str, b bVar) {
        aJr.put(str, bVar);
        aJp += " -s " + str;
    }

    public void gB(String str) {
        String[] split = str.split("\n");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < split.length) {
                Iterator<Map.Entry<String, b>> it = aJr.entrySet().iterator();
                while (true) {
                    if (it.hasNext()) {
                        Map.Entry<String, b> next = it.next();
                        if (split[i2].contains(next.getKey().toString())) {
                            next.getValue().gA(split[i2]);
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
            this.aJm = Runtime.getRuntime().exec(aJp);
            this.aJo = this.aJm.getOutputStream();
            this.aJn = this.aJm.getInputStream();
            Gf();
            this.aJo.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void Gf() throws FileNotFoundException {
        this.aJq = new a(this.aJn);
        this.aJq.start();
    }

    @Override // com.baidu.adp.a.a.a
    public void stop() {
        super.stop();
        try {
            if (this.aJm != null) {
                this.aJm.destroy();
            }
            if (this.aJq != null) {
                this.aJq.finish();
            }
            if (this.aJn != null) {
                this.aJn.close();
            }
            if (this.aJo != null) {
                this.aJo.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends Thread {
        private boolean aJs = false;
        private InputStream in;

        public a(InputStream inputStream) {
            this.in = inputStream;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            int read;
            byte[] bArr = new byte[8192];
            while (!this.aJs && (read = this.in.read(bArr)) != -1) {
                try {
                    String str = new String(bArr, 0, read);
                    if (str != null) {
                        c.this.gB(str);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    return;
                }
            }
        }

        public synchronized void finish() {
            this.aJs = true;
        }
    }
}
