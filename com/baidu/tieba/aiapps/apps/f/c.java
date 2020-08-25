package com.baidu.tieba.aiapps.apps.f;
/* loaded from: classes14.dex */
public class c {
    private static volatile b fts;

    public static synchronized b bDc() {
        b bVar;
        synchronized (c.class) {
            if (fts == null) {
                fts = new b();
            }
            bVar = fts;
        }
        return bVar;
    }
}
