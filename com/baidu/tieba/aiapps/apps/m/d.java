package com.baidu.tieba.aiapps.apps.m;
/* loaded from: classes20.dex */
public class d {
    private static volatile c gfx;

    public static synchronized c bOL() {
        c cVar;
        synchronized (d.class) {
            if (gfx == null) {
                gfx = new c();
            }
            cVar = gfx;
        }
        return cVar;
    }
}
