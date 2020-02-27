package com.baidu.tieba.aiapps.apps.m;
/* loaded from: classes7.dex */
public class d {
    private static volatile c efX;

    public static synchronized c bbd() {
        c cVar;
        synchronized (d.class) {
            if (efX == null) {
                efX = new c();
            }
            cVar = efX;
        }
        return cVar;
    }
}
