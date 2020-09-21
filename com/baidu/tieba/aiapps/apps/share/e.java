package com.baidu.tieba.aiapps.apps.share;
/* loaded from: classes19.dex */
public class e {
    private static volatile d fwZ;

    public static synchronized d bEx() {
        d dVar;
        synchronized (e.class) {
            if (fwZ == null) {
                fwZ = new d();
            }
            dVar = fwZ;
        }
        return dVar;
    }
}
