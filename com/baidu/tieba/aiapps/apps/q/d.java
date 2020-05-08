package com.baidu.tieba.aiapps.apps.q;
/* loaded from: classes7.dex */
public class d {
    private static volatile c eGP;

    public static synchronized c bjx() {
        c cVar;
        synchronized (d.class) {
            if (eGP == null) {
                eGP = new c();
            }
            cVar = eGP;
        }
        return cVar;
    }
}
