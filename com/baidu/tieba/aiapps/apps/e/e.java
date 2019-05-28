package com.baidu.tieba.aiapps.apps.e;
/* loaded from: classes2.dex */
public class e {
    private static volatile d dby;

    public static synchronized d aEn() {
        d dVar;
        synchronized (e.class) {
            if (dby == null) {
                dby = new d();
            }
            dVar = dby;
        }
        return dVar;
    }
}
