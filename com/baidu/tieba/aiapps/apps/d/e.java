package com.baidu.tieba.aiapps.apps.d;
/* loaded from: classes2.dex */
public class e {
    private static volatile d dop;

    public static synchronized d aGw() {
        d dVar;
        synchronized (e.class) {
            if (dop == null) {
                dop = new d();
            }
            dVar = dop;
        }
        return dVar;
    }
}
