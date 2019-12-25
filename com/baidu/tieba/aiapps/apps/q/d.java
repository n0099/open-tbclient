package com.baidu.tieba.aiapps.apps.q;
/* loaded from: classes4.dex */
public class d {
    private static volatile c ece;

    public static synchronized c aYG() {
        c cVar;
        synchronized (d.class) {
            if (ece == null) {
                ece = new c();
            }
            cVar = ece;
        }
        return cVar;
    }
}
