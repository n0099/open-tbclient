package com.baidu.tbadk.j;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.a.a.a implements Runnable {
    public static String aGR = "logcat ";
    private static Map<String, c> aGT = new HashMap();
    private Process aGO;
    private InputStream aGP;
    private OutputStream aGQ;
    private a aGS;

    public static void a(String str, c cVar) {
        aGT.put(str, cVar);
        aGR = String.valueOf(aGR) + " -s " + str;
    }

    public void gq(String str) {
        String[] split = str.split("\n");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < split.length) {
                Iterator<Map.Entry<String, c>> it = aGT.entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Map.Entry<String, c> next = it.next();
                    if (split[i2].contains(next.getKey().toString())) {
                        next.getValue().gp(split[i2]);
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
            this.aGO = Runtime.getRuntime().exec(aGR);
            this.aGQ = this.aGO.getOutputStream();
            this.aGP = this.aGO.getInputStream();
            FH();
            this.aGQ.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void FH() throws FileNotFoundException {
        this.aGS = new a(this.aGP);
        this.aGS.start();
    }

    @Override // com.baidu.adp.a.a.a
    public void stop() {
        super.stop();
        try {
            if (this.aGO != null) {
                this.aGO.destroy();
            }
            if (this.aGS != null) {
                this.aGS.finish();
            }
            if (this.aGP != null) {
                this.aGP.close();
            }
            if (this.aGQ != null) {
                this.aGQ.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends Thread {
        private boolean aGU = false;
        private InputStream in;

        public a(InputStream inputStream) {
            this.in = inputStream;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            int read;
            byte[] bArr = new byte[8192];
            while (!this.aGU && (read = this.in.read(bArr)) != -1) {
                try {
                    String str = new String(bArr, 0, read);
                    if (str != null) {
                        d.this.gq(str);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    return;
                }
            }
        }

        public synchronized void finish() {
            this.aGU = true;
        }
    }
}
