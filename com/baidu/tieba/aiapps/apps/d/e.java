package com.baidu.tieba.aiapps.apps.d;
/* loaded from: classes2.dex */
public class e {
    private static volatile d cSZ;

    public static synchronized d ayX() {
        d dVar;
        synchronized (e.class) {
            if (cSZ == null) {
                cSZ = new d();
            }
            dVar = cSZ;
        }
        return dVar;
    }
}
