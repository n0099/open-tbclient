package com.baidu.tieba.aiapps.apps.m;
/* loaded from: classes20.dex */
public class d {
    private static volatile c fXF;

    public static synchronized c bLK() {
        c cVar;
        synchronized (d.class) {
            if (fXF == null) {
                fXF = new c();
            }
            cVar = fXF;
        }
        return cVar;
    }
}
