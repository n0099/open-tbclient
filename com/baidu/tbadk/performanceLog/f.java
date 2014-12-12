package com.baidu.tbadk.performanceLog;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class f extends com.baidu.adp.a.a.a implements Runnable {
    public static String afG = "logcat ";
    private static Map<String, e> afI = new HashMap();
    private Process afD;
    private InputStream afE;
    private OutputStream afF;
    private g afH;

    public static void a(String str, e eVar) {
        afI.put(str, eVar);
        afG = String.valueOf(afG) + " -s " + str;
    }

    public void eA(String str) {
        String[] split = str.split("\n");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < split.length) {
                Iterator<Map.Entry<String, e>> it = afI.entrySet().iterator();
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
            this.afD = Runtime.getRuntime().exec(afG);
            this.afF = this.afD.getOutputStream();
            this.afE = this.afD.getInputStream();
            yN();
            this.afF.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void yN() {
        this.afH = new g(this, this.afE);
        this.afH.start();
    }

    @Override // com.baidu.adp.a.a.a
    public void stop() {
        super.stop();
        try {
            if (this.afD != null) {
                this.afD.destroy();
            }
            if (this.afH != null) {
                this.afH.finish();
            }
            if (this.afE != null) {
                this.afE.close();
            }
            if (this.afF != null) {
                this.afF.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
