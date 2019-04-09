package com.baidu.tieba.aiapps.apps.o;
/* loaded from: classes2.dex */
public class d {
    private static volatile c cWF;

    public static synchronized c azU() {
        c cVar;
        synchronized (d.class) {
            if (cWF == null) {
                cWF = new c();
            }
            cVar = cWF;
        }
        return cVar;
    }
}
