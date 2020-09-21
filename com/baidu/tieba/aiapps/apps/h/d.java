package com.baidu.tieba.aiapps.apps.h;
/* loaded from: classes19.dex */
public class d {
    private static volatile c fwQ;

    public static synchronized c bEq() {
        c cVar;
        synchronized (d.class) {
            if (fwQ == null) {
                fwQ = new c();
            }
            cVar = fwQ;
        }
        return cVar;
    }
}
