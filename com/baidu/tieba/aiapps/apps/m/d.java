package com.baidu.tieba.aiapps.apps.m;
/* loaded from: classes2.dex */
public class d {
    private static volatile c dhA;

    public static synchronized c aHy() {
        c cVar;
        synchronized (d.class) {
            if (dhA == null) {
                dhA = new c();
            }
            cVar = dhA;
        }
        return cVar;
    }
}
