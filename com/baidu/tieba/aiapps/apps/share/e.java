package com.baidu.tieba.aiapps.apps.share;
/* loaded from: classes2.dex */
public class e {
    private static volatile d dgb;

    public static synchronized d aGc() {
        d dVar;
        synchronized (e.class) {
            if (dgb == null) {
                dgb = new d();
            }
            dVar = dgb;
        }
        return dVar;
    }
}
