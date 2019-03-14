package com.baidu.tieba.aiapps.apps.share;
/* loaded from: classes2.dex */
public class d {
    private static volatile c cWA;

    public static synchronized c azU() {
        c cVar;
        synchronized (d.class) {
            if (cWA == null) {
                cWA = new c();
            }
            cVar = cWA;
        }
        return cVar;
    }
}
