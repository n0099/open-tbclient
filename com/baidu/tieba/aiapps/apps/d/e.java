package com.baidu.tieba.aiapps.apps.d;
/* loaded from: classes2.dex */
public class e {
    private static volatile d dnx;

    public static synchronized d aGu() {
        d dVar;
        synchronized (e.class) {
            if (dnx == null) {
                dnx = new d();
            }
            dVar = dnx;
        }
        return dVar;
    }
}
