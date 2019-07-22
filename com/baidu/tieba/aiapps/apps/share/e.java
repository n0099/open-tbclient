package com.baidu.tieba.aiapps.apps.share;
/* loaded from: classes2.dex */
public class e {
    private static volatile d dhK;

    public static synchronized d aHB() {
        d dVar;
        synchronized (e.class) {
            if (dhK == null) {
                dhK = new d();
            }
            dVar = dhK;
        }
        return dVar;
    }
}
