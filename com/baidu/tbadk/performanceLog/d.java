package com.baidu.tbadk.performanceLog;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.a.a.a implements Runnable {
    public static String avr = "logcat ";
    private static Map<String, c> avt = new HashMap();
    private Process avo;
    private InputStream avp;
    private OutputStream avq;
    private a avs;

    public static void a(String str, c cVar) {
        avt.put(str, cVar);
        avr = String.valueOf(avr) + " -s " + str;
    }

    public void fC(String str) {
        String[] split = str.split("\n");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < split.length) {
                Iterator<Map.Entry<String, c>> it = avt.entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Map.Entry<String, c> next = it.next();
                    if (split[i2].contains(next.getKey().toString())) {
                        next.getValue().fB(split[i2]);
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
            this.avo = Runtime.getRuntime().exec(avr);
            this.avq = this.avo.getOutputStream();
            this.avp = this.avo.getInputStream();
            Dt();
            this.avq.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void Dt() {
        this.avs = new a(this.avp);
        this.avs.start();
    }

    @Override // com.baidu.adp.a.a.a
    public void stop() {
        super.stop();
        try {
            if (this.avo != null) {
                this.avo.destroy();
            }
            if (this.avs != null) {
                this.avs.finish();
            }
            if (this.avp != null) {
                this.avp.close();
            }
            if (this.avq != null) {
                this.avq.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends Thread {
        private boolean avu = false;
        private InputStream in;

        public a(InputStream inputStream) {
            this.in = inputStream;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            int read;
            byte[] bArr = new byte[8192];
            while (!this.avu && (read = this.in.read(bArr)) != -1) {
                try {
                    String str = new String(bArr, 0, read);
                    if (str != null) {
                        d.this.fC(str);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    return;
                }
            }
        }

        public synchronized void finish() {
            this.avu = true;
        }
    }
}
