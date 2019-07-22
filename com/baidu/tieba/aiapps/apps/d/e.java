package com.baidu.tieba.aiapps.apps.d;
/* loaded from: classes2.dex */
public class e {
    private static volatile d dda;

    public static synchronized d aFD() {
        d dVar;
        synchronized (e.class) {
            if (dda == null) {
                dda = new d();
            }
            dVar = dda;
        }
        return dVar;
    }
}
