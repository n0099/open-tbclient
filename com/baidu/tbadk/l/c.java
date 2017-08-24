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
    public static String aJq = "logcat ";
    private static Map<String, b> aJs = new HashMap();
    private Process aJn;
    private InputStream aJo;
    private OutputStream aJp;
    private a aJr;

    public static void a(String str, b bVar) {
        aJs.put(str, bVar);
        aJq += " -s " + str;
    }

    public void gE(String str) {
        String[] split = str.split("\n");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < split.length) {
                Iterator<Map.Entry<String, b>> it = aJs.entrySet().iterator();
                while (true) {
                    if (it.hasNext()) {
                        Map.Entry<String, b> next = it.next();
                        if (split[i2].contains(next.getKey().toString())) {
                            next.getValue().gD(split[i2]);
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
            this.aJn = Runtime.getRuntime().exec(aJq);
            this.aJp = this.aJn.getOutputStream();
            this.aJo = this.aJn.getInputStream();
            Gf();
            this.aJp.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void Gf() throws FileNotFoundException {
        this.aJr = new a(this.aJo);
        this.aJr.start();
    }

    @Override // com.baidu.adp.a.a.a
    public void stop() {
        super.stop();
        try {
            if (this.aJn != null) {
                this.aJn.destroy();
            }
            if (this.aJr != null) {
                this.aJr.finish();
            }
            if (this.aJo != null) {
                this.aJo.close();
            }
            if (this.aJp != null) {
                this.aJp.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends Thread {
        private boolean aJt = false;
        private InputStream in;

        public a(InputStream inputStream) {
            this.in = inputStream;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            int read;
            byte[] bArr = new byte[8192];
            while (!this.aJt && (read = this.in.read(bArr)) != -1) {
                try {
                    String str = new String(bArr, 0, read);
                    if (str != null) {
                        c.this.gE(str);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    return;
                }
            }
        }

        public synchronized void finish() {
            this.aJt = true;
        }
    }
}
