package com.baidu.tieba.aiapps.apps.d;
/* loaded from: classes2.dex */
public class e {
    private static volatile d cTb;

    public static synchronized d azb() {
        d dVar;
        synchronized (e.class) {
            if (cTb == null) {
                cTb = new d();
            }
            dVar = cTb;
        }
        return dVar;
    }
}
