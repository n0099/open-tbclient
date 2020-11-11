package com.baidu.tieba.aiapps.apps.h;
/* loaded from: classes20.dex */
public class d {
    private static volatile c fXk;

    public static synchronized c bLu() {
        c cVar;
        synchronized (d.class) {
            if (fXk == null) {
                fXk = new c();
            }
            cVar = fXk;
        }
        return cVar;
    }
}
