package com.baidu.tieba.aiapps.apps.q;
/* loaded from: classes7.dex */
public class d {
    private static volatile c eGK;

    public static synchronized c bjz() {
        c cVar;
        synchronized (d.class) {
            if (eGK == null) {
                eGK = new c();
            }
            cVar = eGK;
        }
        return cVar;
    }
}
