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
    public static String aIf = "logcat ";
    private static Map<String, b> aIh = new HashMap();
    private Process aIc;
    private InputStream aId;
    private OutputStream aIe;
    private a aIg;

    public static void a(String str, b bVar) {
        aIh.put(str, bVar);
        aIf += " -s " + str;
    }

    public void gw(String str) {
        String[] split = str.split("\n");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < split.length) {
                Iterator<Map.Entry<String, b>> it = aIh.entrySet().iterator();
                while (true) {
                    if (it.hasNext()) {
                        Map.Entry<String, b> next = it.next();
                        if (split[i2].contains(next.getKey().toString())) {
                            next.getValue().gv(split[i2]);
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
            this.aIc = Runtime.getRuntime().exec(aIf);
            this.aIe = this.aIc.getOutputStream();
            this.aId = this.aIc.getInputStream();
            FC();
            this.aIe.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void FC() throws FileNotFoundException {
        this.aIg = new a(this.aId);
        this.aIg.start();
    }

    @Override // com.baidu.adp.a.a.a
    public void stop() {
        super.stop();
        try {
            if (this.aIc != null) {
                this.aIc.destroy();
            }
            if (this.aIg != null) {
                this.aIg.finish();
            }
            if (this.aId != null) {
                this.aId.close();
            }
            if (this.aIe != null) {
                this.aIe.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends Thread {
        private boolean aIi = false;
        private InputStream in;

        public a(InputStream inputStream) {
            this.in = inputStream;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            int read;
            byte[] bArr = new byte[8192];
            while (!this.aIi && (read = this.in.read(bArr)) != -1) {
                try {
                    String str = new String(bArr, 0, read);
                    if (str != null) {
                        c.this.gw(str);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    return;
                }
            }
        }

        public synchronized void finish() {
            this.aIi = true;
        }
    }
}
