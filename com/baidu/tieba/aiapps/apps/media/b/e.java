package com.baidu.tieba.aiapps.apps.media.b;
/* loaded from: classes2.dex */
public class e {
    private static volatile d dfl;

    public static synchronized d aGf() {
        d dVar;
        synchronized (e.class) {
            if (dfl == null) {
                dfl = new d();
            }
            dVar = dfl;
        }
        return dVar;
    }
}
