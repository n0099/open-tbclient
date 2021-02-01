package com.baidu.tieba.aiapps.apps.h;
/* loaded from: classes7.dex */
public class d {
    private static volatile c gmt;

    public static synchronized c bNy() {
        c cVar;
        synchronized (d.class) {
            if (gmt == null) {
                gmt = new c();
            }
            cVar = gmt;
        }
        return cVar;
    }
}
