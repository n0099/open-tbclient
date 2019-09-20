package com.baidu.tieba.aiapps.apps.m;
/* loaded from: classes2.dex */
public class d {
    private static volatile c djl;

    public static synchronized c aIc() {
        c cVar;
        synchronized (d.class) {
            if (djl == null) {
                djl = new c();
            }
            cVar = djl;
        }
        return cVar;
    }
}
