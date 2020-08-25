package com.baidu.tieba.aiapps.apps.share;
/* loaded from: classes14.dex */
public class e {
    private static volatile d ftL;

    public static synchronized d bDk() {
        d dVar;
        synchronized (e.class) {
            if (ftL == null) {
                ftL = new d();
            }
            dVar = ftL;
        }
        return dVar;
    }
}
