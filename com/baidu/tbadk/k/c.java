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
    private Process aJv;
    private InputStream aJw;
    private OutputStream aJx;
    private a aJz;
    public static String aJy = "logcat ";
    private static Map<String, b> aJA = new HashMap();

    public static void a(String str, b bVar) {
        aJA.put(str, bVar);
        aJy += " -s " + str;
    }

    public void gH(String str) {
        String[] split = str.split("\n");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < split.length) {
                Iterator<Map.Entry<String, b>> it = aJA.entrySet().iterator();
                while (true) {
                    if (it.hasNext()) {
                        Map.Entry<String, b> next = it.next();
                        if (split[i2].contains(next.getKey().toString())) {
                            next.getValue().gG(split[i2]);
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
            this.aJv = Runtime.getRuntime().exec(aJy);
            this.aJx = this.aJv.getOutputStream();
            this.aJw = this.aJv.getInputStream();
            Gg();
            this.aJx.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void Gg() throws FileNotFoundException {
        this.aJz = new a(this.aJw);
        this.aJz.start();
    }

    @Override // com.baidu.adp.a.a.a
    public void stop() {
        super.stop();
        try {
            if (this.aJv != null) {
                this.aJv.destroy();
            }
            if (this.aJz != null) {
                this.aJz.finish();
            }
            if (this.aJw != null) {
                this.aJw.close();
            }
            if (this.aJx != null) {
                this.aJx.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends Thread {
        private boolean aJB = false;
        private InputStream in;

        public a(InputStream inputStream) {
            this.in = inputStream;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            int read;
            byte[] bArr = new byte[8192];
            while (!this.aJB && (read = this.in.read(bArr)) != -1) {
                try {
                    String str = new String(bArr, 0, read);
                    if (str != null) {
                        c.this.gH(str);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    return;
                }
            }
        }

        public synchronized void finish() {
            this.aJB = true;
        }
    }
}
