package com.baidu.tieba.aiapps.apps.m;
/* loaded from: classes19.dex */
public class d {
    private static volatile c fxl;

    public static synchronized c bEG() {
        c cVar;
        synchronized (d.class) {
            if (fxl == null) {
                fxl = new c();
            }
            cVar = fxl;
        }
        return cVar;
    }
}
