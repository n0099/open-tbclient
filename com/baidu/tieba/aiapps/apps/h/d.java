package com.baidu.tieba.aiapps.apps.h;
/* loaded from: classes7.dex */
public class d {
    private static volatile c fdw;

    public static synchronized c brf() {
        c cVar;
        synchronized (d.class) {
            if (fdw == null) {
                fdw = new c();
            }
            cVar = fdw;
        }
        return cVar;
    }
}
