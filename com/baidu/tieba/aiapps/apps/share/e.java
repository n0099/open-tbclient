package com.baidu.tieba.aiapps.apps.share;
/* loaded from: classes20.dex */
public class e {
    private static volatile d gfn;

    public static synchronized d bOD() {
        d dVar;
        synchronized (e.class) {
            if (gfn == null) {
                gfn = new d();
            }
            dVar = gfn;
        }
        return dVar;
    }
}
