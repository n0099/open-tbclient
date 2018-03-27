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
    public static String bzI = "logcat ";
    private static Map<String, b> bzK = new HashMap();
    private Process bzF;
    private InputStream bzG;
    private OutputStream bzH;
    private a bzJ;

    public static void a(String str, b bVar) {
        bzK.put(str, bVar);
        bzI += " -s " + str;
    }

    public void hb(String str) {
        String[] split = str.split("\n");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < split.length) {
                Iterator<Map.Entry<String, b>> it = bzK.entrySet().iterator();
                while (true) {
                    if (it.hasNext()) {
                        Map.Entry<String, b> next = it.next();
                        if (split[i2].contains(next.getKey().toString())) {
                            next.getValue().ha(split[i2]);
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
            this.bzF = Runtime.getRuntime().exec(bzI);
            this.bzH = this.bzF.getOutputStream();
            this.bzG = this.bzF.getInputStream();
            Oc();
            this.bzH.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void Oc() throws FileNotFoundException {
        this.bzJ = new a(this.bzG);
        this.bzJ.start();
    }

    @Override // com.baidu.adp.a.a.a
    public void stop() {
        super.stop();
        try {
            if (this.bzF != null) {
                this.bzF.destroy();
            }
            if (this.bzJ != null) {
                this.bzJ.finish();
            }
            if (this.bzG != null) {
                this.bzG.close();
            }
            if (this.bzH != null) {
                this.bzH.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends Thread {
        private boolean bzL = false;
        private InputStream in;

        public a(InputStream inputStream) {
            this.in = inputStream;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            int read;
            byte[] bArr = new byte[8192];
            while (!this.bzL && (read = this.in.read(bArr)) != -1) {
                try {
                    String str = new String(bArr, 0, read);
                    if (str != null) {
                        c.this.hb(str);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    return;
                }
            }
        }

        public synchronized void finish() {
            this.bzL = true;
        }
    }
}
