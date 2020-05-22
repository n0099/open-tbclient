package com.baidu.tieba.aiapps.apps.share;
/* loaded from: classes7.dex */
public class e {
    private static volatile d eTj;

    public static synchronized d boG() {
        d dVar;
        synchronized (e.class) {
            if (eTj == null) {
                eTj = new d();
            }
            dVar = eTj;
        }
        return dVar;
    }
}
