package com.baidu.tbadk.performanceLog;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.a.a.a implements Runnable {
    public static String aza = "logcat ";
    private static Map<String, c> azc = new HashMap();
    private Process ayX;
    private InputStream ayY;
    private OutputStream ayZ;
    private a azb;

    public static void a(String str, c cVar) {
        azc.put(str, cVar);
        aza = String.valueOf(aza) + " -s " + str;
    }

    public void fU(String str) {
        String[] split = str.split("\n");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < split.length) {
                Iterator<Map.Entry<String, c>> it = azc.entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Map.Entry<String, c> next = it.next();
                    if (split[i2].contains(next.getKey().toString())) {
                        next.getValue().fT(split[i2]);
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
            this.ayX = Runtime.getRuntime().exec(aza);
            this.ayZ = this.ayX.getOutputStream();
            this.ayY = this.ayX.getInputStream();
            Ej();
            this.ayZ.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void Ej() {
        this.azb = new a(this.ayY);
        this.azb.start();
    }

    @Override // com.baidu.adp.a.a.a
    public void stop() {
        super.stop();
        try {
            if (this.ayX != null) {
                this.ayX.destroy();
            }
            if (this.azb != null) {
                this.azb.finish();
            }
            if (this.ayY != null) {
                this.ayY.close();
            }
            if (this.ayZ != null) {
                this.ayZ.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends Thread {
        private boolean azd = false;
        private InputStream in;

        public a(InputStream inputStream) {
            this.in = inputStream;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            int read;
            byte[] bArr = new byte[8192];
            while (!this.azd && (read = this.in.read(bArr)) != -1) {
                try {
                    String str = new String(bArr, 0, read);
                    if (str != null) {
                        d.this.fU(str);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    return;
                }
            }
        }

        public synchronized void finish() {
            this.azd = true;
        }
    }
}
