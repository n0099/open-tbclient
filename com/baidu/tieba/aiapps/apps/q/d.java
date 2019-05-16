package com.baidu.tieba.aiapps.apps.q;
/* loaded from: classes2.dex */
public class d {
    private static volatile c dgd;

    public static synchronized c aGf() {
        c cVar;
        synchronized (d.class) {
            if (dgd == null) {
                dgd = new c();
            }
            cVar = dgd;
        }
        return cVar;
    }
}
