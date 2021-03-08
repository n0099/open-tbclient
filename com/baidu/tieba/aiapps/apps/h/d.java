package com.baidu.tieba.aiapps.apps.h;
/* loaded from: classes6.dex */
public class d {
    private static volatile c goq;

    public static synchronized c bNL() {
        c cVar;
        synchronized (d.class) {
            if (goq == null) {
                goq = new c();
            }
            cVar = goq;
        }
        return cVar;
    }
}
