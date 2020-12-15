package com.baidu.tieba.aiapps.apps.m;
/* loaded from: classes20.dex */
public class d {
    private static volatile c gfz;

    public static synchronized c bOM() {
        c cVar;
        synchronized (d.class) {
            if (gfz == null) {
                gfz = new c();
            }
            cVar = gfz;
        }
        return cVar;
    }
}
