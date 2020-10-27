package com.baidu.tieba.aiapps.apps.share;
/* loaded from: classes20.dex */
public class e {
    private static volatile d fRD;

    public static synchronized d bJc() {
        d dVar;
        synchronized (e.class) {
            if (fRD == null) {
                fRD = new d();
            }
            dVar = fRD;
        }
        return dVar;
    }
}
