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
    public static String aIR = "logcat ";
    private static Map<String, b> aIT = new HashMap();
    private Process aIO;
    private InputStream aIP;
    private OutputStream aIQ;
    private a aIS;

    public static void a(String str, b bVar) {
        aIT.put(str, bVar);
        aIR += " -s " + str;
    }

    public void gA(String str) {
        String[] split = str.split("\n");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < split.length) {
                Iterator<Map.Entry<String, b>> it = aIT.entrySet().iterator();
                while (true) {
                    if (it.hasNext()) {
                        Map.Entry<String, b> next = it.next();
                        if (split[i2].contains(next.getKey().toString())) {
                            next.getValue().gz(split[i2]);
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
            this.aIO = Runtime.getRuntime().exec(aIR);
            this.aIQ = this.aIO.getOutputStream();
            this.aIP = this.aIO.getInputStream();
            Gd();
            this.aIQ.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void Gd() throws FileNotFoundException {
        this.aIS = new a(this.aIP);
        this.aIS.start();
    }

    @Override // com.baidu.adp.a.a.a
    public void stop() {
        super.stop();
        try {
            if (this.aIO != null) {
                this.aIO.destroy();
            }
            if (this.aIS != null) {
                this.aIS.finish();
            }
            if (this.aIP != null) {
                this.aIP.close();
            }
            if (this.aIQ != null) {
                this.aIQ.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends Thread {
        private boolean aIU = false;
        private InputStream in;

        public a(InputStream inputStream) {
            this.in = inputStream;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            int read;
            byte[] bArr = new byte[8192];
            while (!this.aIU && (read = this.in.read(bArr)) != -1) {
                try {
                    String str = new String(bArr, 0, read);
                    if (str != null) {
                        c.this.gA(str);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    return;
                }
            }
        }

        public synchronized void finish() {
            this.aIU = true;
        }
    }
}
