package com.baidu.tieba.aiapps.apps.o;
/* loaded from: classes2.dex */
public class d {
    private static volatile c cWC;

    public static synchronized c azX() {
        c cVar;
        synchronized (d.class) {
            if (cWC == null) {
                cWC = new c();
            }
            cVar = cWC;
        }
        return cVar;
    }
}
