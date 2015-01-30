package com.baidu.tbadk.performanceLog;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class f extends com.baidu.adp.a.a.a implements Runnable {
    public static String agd = "logcat ";
    private static Map<String, e> agf = new HashMap();
    private Process aga;
    private InputStream agb;
    private OutputStream agc;
    private g age;

    public static void a(String str, e eVar) {
        agf.put(str, eVar);
        agd = String.valueOf(agd) + " -s " + str;
    }

    public void eA(String str) {
        String[] split = str.split("\n");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < split.length) {
                Iterator<Map.Entry<String, e>> it = agf.entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Map.Entry<String, e> next = it.next();
                    if (split[i2].contains(next.getKey().toString())) {
                        next.getValue().ez(split[i2]);
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
            this.aga = Runtime.getRuntime().exec(agd);
            this.agc = this.aga.getOutputStream();
            this.agb = this.aga.getInputStream();
            ze();
            this.agc.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void ze() {
        this.age = new g(this, this.agb);
        this.age.start();
    }

    @Override // com.baidu.adp.a.a.a
    public void stop() {
        super.stop();
        try {
            if (this.aga != null) {
                this.aga.destroy();
            }
            if (this.age != null) {
                this.age.finish();
            }
            if (this.agb != null) {
                this.agb.close();
            }
            if (this.agc != null) {
                this.agc.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
