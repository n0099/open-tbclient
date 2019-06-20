package com.baidu.tieba.aiapps.apps.e;
/* loaded from: classes2.dex */
public class e {
    private static volatile d dbz;

    public static synchronized d aEn() {
        d dVar;
        synchronized (e.class) {
            if (dbz == null) {
                dbz = new d();
            }
            dVar = dbz;
        }
        return dVar;
    }
}
