package com.baidu.tieba.aiapps.apps.share;
/* loaded from: classes14.dex */
public class e {
    private static volatile d ftP;

    public static synchronized d bDl() {
        d dVar;
        synchronized (e.class) {
            if (ftP == null) {
                ftP = new d();
            }
            dVar = ftP;
        }
        return dVar;
    }
}
