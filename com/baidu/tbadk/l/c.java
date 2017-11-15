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
    public static String aIX = "logcat ";
    private static Map<String, b> aIZ = new HashMap();
    private Process aIU;
    private InputStream aIV;
    private OutputStream aIW;
    private a aIY;

    public static void a(String str, b bVar) {
        aIZ.put(str, bVar);
        aIX += " -s " + str;
    }

    public void gE(String str) {
        String[] split = str.split("\n");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < split.length) {
                Iterator<Map.Entry<String, b>> it = aIZ.entrySet().iterator();
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
            this.aIU = Runtime.getRuntime().exec(aIX);
            this.aIW = this.aIU.getOutputStream();
            this.aIV = this.aIU.getInputStream();
            FZ();
            this.aIW.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void FZ() throws FileNotFoundException {
        this.aIY = new a(this.aIV);
        this.aIY.start();
    }

    @Override // com.baidu.adp.a.a.a
    public void stop() {
        super.stop();
        try {
            if (this.aIU != null) {
                this.aIU.destroy();
            }
            if (this.aIY != null) {
                this.aIY.finish();
            }
            if (this.aIV != null) {
                this.aIV.close();
            }
            if (this.aIW != null) {
                this.aIW.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends Thread {
        private boolean aJa = false;
        private InputStream in;

        public a(InputStream inputStream) {
            this.in = inputStream;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            int read;
            byte[] bArr = new byte[8192];
            while (!this.aJa && (read = this.in.read(bArr)) != -1) {
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
            this.aJa = true;
        }
    }
}
