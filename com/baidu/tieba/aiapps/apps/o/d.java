package com.baidu.tieba.aiapps.apps.o;
/* loaded from: classes2.dex */
public class d {
    private static volatile c cWG;

    public static synchronized c azY() {
        c cVar;
        synchronized (d.class) {
            if (cWG == null) {
                cWG = new c();
            }
            cVar = cWG;
        }
        return cVar;
    }
}
