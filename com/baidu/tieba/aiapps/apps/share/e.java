package com.baidu.tieba.aiapps.apps.share;
/* loaded from: classes20.dex */
public class e {
    private static volatile d gfl;

    public static synchronized d bOC() {
        d dVar;
        synchronized (e.class) {
            if (gfl == null) {
                gfl = new d();
            }
            dVar = gfl;
        }
        return dVar;
    }
}
