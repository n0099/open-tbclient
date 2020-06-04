package com.baidu.tieba.aiapps.apps.share;
/* loaded from: classes7.dex */
public class e {
    private static volatile d eTu;

    public static synchronized d boI() {
        d dVar;
        synchronized (e.class) {
            if (eTu == null) {
                eTu = new d();
            }
            dVar = eTu;
        }
        return dVar;
    }
}
