package com.baidu.tieba.aiapps.apps.e;
/* loaded from: classes2.dex */
public class e {
    private static volatile d dbx;

    public static synchronized d aEk() {
        d dVar;
        synchronized (e.class) {
            if (dbx == null) {
                dbx = new d();
            }
            dVar = dbx;
        }
        return dVar;
    }
}
