package com.baidu.tieba.aiapps.apps.q;
/* loaded from: classes7.dex */
public class d {
    private static volatile c egr;

    public static synchronized c bbr() {
        c cVar;
        synchronized (d.class) {
            if (egr == null) {
                egr = new c();
            }
            cVar = egr;
        }
        return cVar;
    }
}
