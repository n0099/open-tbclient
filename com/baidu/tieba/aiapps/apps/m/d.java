package com.baidu.tieba.aiapps.apps.m;
/* loaded from: classes2.dex */
public class d {
    private static volatile c dsF;

    public static synchronized c aIm() {
        c cVar;
        synchronized (d.class) {
            if (dsF == null) {
                dsF = new c();
            }
            cVar = dsF;
        }
        return cVar;
    }
}
