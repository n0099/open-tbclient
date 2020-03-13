package com.baidu.tieba.aiapps.apps.q;
/* loaded from: classes7.dex */
public class d {
    private static volatile c egE;

    public static synchronized c bbs() {
        c cVar;
        synchronized (d.class) {
            if (egE == null) {
                egE = new c();
            }
            cVar = egE;
        }
        return cVar;
    }
}
