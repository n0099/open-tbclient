package com.baidu.tieba.aiapps.apps.q;
/* loaded from: classes7.dex */
public class d {
    private static volatile c egU;

    public static synchronized c bbw() {
        c cVar;
        synchronized (d.class) {
            if (egU == null) {
                egU = new c();
            }
            cVar = egU;
        }
        return cVar;
    }
}
