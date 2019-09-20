package com.baidu.tieba.aiapps.apps.media.b;
/* loaded from: classes2.dex */
public class e {
    private static volatile d dhd;

    public static synchronized d aGL() {
        d dVar;
        synchronized (e.class) {
            if (dhd == null) {
                dhd = new d();
            }
            dVar = dhd;
        }
        return dVar;
    }
}
