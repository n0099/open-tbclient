package com.baidu.tieba.aiapps.apps.share;
/* loaded from: classes2.dex */
public class d {
    private static volatile c cWE;

    public static synchronized c azU() {
        c cVar;
        synchronized (d.class) {
            if (cWE == null) {
                cWE = new c();
            }
            cVar = cWE;
        }
        return cVar;
    }
}
