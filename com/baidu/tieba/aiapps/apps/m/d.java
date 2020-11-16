package com.baidu.tieba.aiapps.apps.m;
/* loaded from: classes19.dex */
public class d {
    private static volatile c fXm;

    public static synchronized c bLd() {
        c cVar;
        synchronized (d.class) {
            if (fXm == null) {
                fXm = new c();
            }
            cVar = fXm;
        }
        return cVar;
    }
}
