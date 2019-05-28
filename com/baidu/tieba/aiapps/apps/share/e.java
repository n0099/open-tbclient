package com.baidu.tieba.aiapps.apps.share;
/* loaded from: classes2.dex */
public class e {
    private static volatile d dgc;

    public static synchronized d aGf() {
        d dVar;
        synchronized (e.class) {
            if (dgc == null) {
                dgc = new d();
            }
            dVar = dgc;
        }
        return dVar;
    }
}
