package com.baidu.tieba.aiapps.apps.q;
/* loaded from: classes5.dex */
public class d {
    private static volatile c ecn;

    public static synchronized c aZa() {
        c cVar;
        synchronized (d.class) {
            if (ecn == null) {
                ecn = new c();
            }
            cVar = ecn;
        }
        return cVar;
    }
}
