package com.baidu.tieba.aiapps.apps.share;
/* loaded from: classes14.dex */
public class e {
    private static volatile d fin;

    public static synchronized d bup() {
        d dVar;
        synchronized (e.class) {
            if (fin == null) {
                fin = new d();
            }
            dVar = fin;
        }
        return dVar;
    }
}
