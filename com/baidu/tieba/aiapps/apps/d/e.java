package com.baidu.tieba.aiapps.apps.d;
/* loaded from: classes2.dex */
public class e {
    private static volatile d cTa;

    public static synchronized d ayX() {
        d dVar;
        synchronized (e.class) {
            if (cTa == null) {
                cTa = new d();
            }
            dVar = cTa;
        }
        return dVar;
    }
}
