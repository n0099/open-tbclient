package com.baidu.tbadk.performanceLog;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class f extends com.baidu.adp.a.a.a implements Runnable {
    public static String apI = "logcat ";
    private static Map<String, e> apK = new HashMap();
    private Process apF;
    private InputStream apG;
    private OutputStream apH;
    private g apJ;

    public static void a(String str, e eVar) {
        apK.put(str, eVar);
        apI = String.valueOf(apI) + " -s " + str;
    }

    public void eV(String str) {
        String[] split = str.split("\n");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < split.length) {
                Iterator<Map.Entry<String, e>> it = apK.entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Map.Entry<String, e> next = it.next();
                    if (split[i2].contains(next.getKey().toString())) {
                        next.getValue().eU(split[i2]);
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
            this.apF = Runtime.getRuntime().exec(apI);
            this.apH = this.apF.getOutputStream();
            this.apG = this.apF.getInputStream();
            Dd();
            this.apH.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void Dd() {
        this.apJ = new g(this, this.apG);
        this.apJ.start();
    }

    @Override // com.baidu.adp.a.a.a
    public void stop() {
        super.stop();
        try {
            if (this.apF != null) {
                this.apF.destroy();
            }
            if (this.apJ != null) {
                this.apJ.finish();
            }
            if (this.apG != null) {
                this.apG.close();
            }
            if (this.apH != null) {
                this.apH.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
