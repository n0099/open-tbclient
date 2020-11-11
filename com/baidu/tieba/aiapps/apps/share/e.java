package com.baidu.tieba.aiapps.apps.share;
/* loaded from: classes20.dex */
public class e {
    private static volatile d fXt;

    public static synchronized d bLB() {
        d dVar;
        synchronized (e.class) {
            if (fXt == null) {
                fXt = new d();
            }
            dVar = fXt;
        }
        return dVar;
    }
}
