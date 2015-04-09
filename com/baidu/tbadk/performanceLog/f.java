package com.baidu.tbadk.performanceLog;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class f extends com.baidu.adp.a.a.a implements Runnable {
    public static String aoD = "logcat ";
    private static Map<String, e> aoF = new HashMap();
    private Process aoA;
    private InputStream aoB;
    private OutputStream aoC;
    private g aoE;

    public static void a(String str, e eVar) {
        aoF.put(str, eVar);
        aoD = String.valueOf(aoD) + " -s " + str;
    }

    public void eE(String str) {
        String[] split = str.split("\n");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < split.length) {
                Iterator<Map.Entry<String, e>> it = aoF.entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Map.Entry<String, e> next = it.next();
                    if (split[i2].contains(next.getKey().toString())) {
                        next.getValue().eD(split[i2]);
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
            this.aoA = Runtime.getRuntime().exec(aoD);
            this.aoC = this.aoA.getOutputStream();
            this.aoB = this.aoA.getInputStream();
            Cs();
            this.aoC.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void Cs() {
        this.aoE = new g(this, this.aoB);
        this.aoE.start();
    }

    @Override // com.baidu.adp.a.a.a
    public void stop() {
        super.stop();
        try {
            if (this.aoA != null) {
                this.aoA.destroy();
            }
            if (this.aoE != null) {
                this.aoE.finish();
            }
            if (this.aoB != null) {
                this.aoB.close();
            }
            if (this.aoC != null) {
                this.aoC.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
