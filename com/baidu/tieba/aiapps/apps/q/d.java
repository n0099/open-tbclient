package com.baidu.tieba.aiapps.apps.q;
/* loaded from: classes7.dex */
public class d {
    private static volatile c egq;

    public static synchronized c bbp() {
        c cVar;
        synchronized (d.class) {
            if (egq == null) {
                egq = new c();
            }
            cVar = egq;
        }
        return cVar;
    }
}
