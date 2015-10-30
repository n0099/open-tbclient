package com.baidu.tbadk.performanceLog;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.a.a.a implements Runnable {
    public static String awD = "logcat ";
    private static Map<String, c> awF = new HashMap();
    private Process awA;
    private InputStream awB;
    private OutputStream awC;
    private a awE;

    public static void a(String str, c cVar) {
        awF.put(str, cVar);
        awD = String.valueOf(awD) + " -s " + str;
    }

    public void fA(String str) {
        String[] split = str.split("\n");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < split.length) {
                Iterator<Map.Entry<String, c>> it = awF.entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Map.Entry<String, c> next = it.next();
                    if (split[i2].contains(next.getKey().toString())) {
                        next.getValue().fz(split[i2]);
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
            this.awA = Runtime.getRuntime().exec(awD);
            this.awC = this.awA.getOutputStream();
            this.awB = this.awA.getInputStream();
            DA();
            this.awC.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void DA() {
        this.awE = new a(this.awB);
        this.awE.start();
    }

    @Override // com.baidu.adp.a.a.a
    public void stop() {
        super.stop();
        try {
            if (this.awA != null) {
                this.awA.destroy();
            }
            if (this.awE != null) {
                this.awE.finish();
            }
            if (this.awB != null) {
                this.awB.close();
            }
            if (this.awC != null) {
                this.awC.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends Thread {
        private boolean awG = false;
        private InputStream in;

        public a(InputStream inputStream) {
            this.in = inputStream;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            int read;
            byte[] bArr = new byte[8192];
            while (!this.awG && (read = this.in.read(bArr)) != -1) {
                try {
                    String str = new String(bArr, 0, read);
                    if (str != null) {
                        d.this.fA(str);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    return;
                }
            }
        }

        public synchronized void finish() {
            this.awG = true;
        }
    }
}
