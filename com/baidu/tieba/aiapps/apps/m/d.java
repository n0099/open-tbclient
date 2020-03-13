package com.baidu.tieba.aiapps.apps.m;
/* loaded from: classes7.dex */
public class d {
    private static volatile c egl;

    public static synchronized c bbg() {
        c cVar;
        synchronized (d.class) {
            if (egl == null) {
                egl = new c();
            }
            cVar = egl;
        }
        return cVar;
    }
}
