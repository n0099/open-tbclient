package com.baidu.tieba.aiapps.apps.share;
/* loaded from: classes19.dex */
public class e {
    private static volatile d fXa;

    public static synchronized d bKU() {
        d dVar;
        synchronized (e.class) {
            if (fXa == null) {
                fXa = new d();
            }
            dVar = fXa;
        }
        return dVar;
    }
}
