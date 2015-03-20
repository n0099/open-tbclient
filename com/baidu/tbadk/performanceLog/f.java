package com.baidu.tbadk.performanceLog;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class f extends com.baidu.adp.a.a.a implements Runnable {
    public static String aov = "logcat ";
    private static Map<String, e> aox = new HashMap();
    private Process aos;
    private InputStream aot;
    private OutputStream aou;
    private g aow;

    public static void a(String str, e eVar) {
        aox.put(str, eVar);
        aov = String.valueOf(aov) + " -s " + str;
    }

    public void eB(String str) {
        String[] split = str.split("\n");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < split.length) {
                Iterator<Map.Entry<String, e>> it = aox.entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Map.Entry<String, e> next = it.next();
                    if (split[i2].contains(next.getKey().toString())) {
                        next.getValue().eA(split[i2]);
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
            this.aos = Runtime.getRuntime().exec(aov);
            this.aou = this.aos.getOutputStream();
            this.aot = this.aos.getInputStream();
            Cm();
            this.aou.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void Cm() {
        this.aow = new g(this, this.aot);
        this.aow.start();
    }

    @Override // com.baidu.adp.a.a.a
    public void stop() {
        super.stop();
        try {
            if (this.aos != null) {
                this.aos.destroy();
            }
            if (this.aow != null) {
                this.aow.finish();
            }
            if (this.aot != null) {
                this.aot.close();
            }
            if (this.aou != null) {
                this.aou.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
