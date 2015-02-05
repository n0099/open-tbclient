package com.baidu.tbadk.performanceLog;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class f extends com.baidu.adp.a.a.a implements Runnable {
    public static String aga = "logcat ";
    private static Map<String, e> agc = new HashMap();
    private Process afX;
    private InputStream afY;
    private OutputStream afZ;
    private g agb;

    public static void a(String str, e eVar) {
        agc.put(str, eVar);
        aga = String.valueOf(aga) + " -s " + str;
    }

    public void ex(String str) {
        String[] split = str.split("\n");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < split.length) {
                Iterator<Map.Entry<String, e>> it = agc.entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Map.Entry<String, e> next = it.next();
                    if (split[i2].contains(next.getKey().toString())) {
                        next.getValue().ew(split[i2]);
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
            this.afX = Runtime.getRuntime().exec(aga);
            this.afZ = this.afX.getOutputStream();
            this.afY = this.afX.getInputStream();
            yY();
            this.afZ.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void yY() {
        this.agb = new g(this, this.afY);
        this.agb.start();
    }

    @Override // com.baidu.adp.a.a.a
    public void stop() {
        super.stop();
        try {
            if (this.afX != null) {
                this.afX.destroy();
            }
            if (this.agb != null) {
                this.agb.finish();
            }
            if (this.afY != null) {
                this.afY.close();
            }
            if (this.afZ != null) {
                this.afZ.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
