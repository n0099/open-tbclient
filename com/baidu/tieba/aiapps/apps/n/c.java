package com.baidu.tieba.aiapps.apps.n;
/* loaded from: classes20.dex */
public class c {
    private static volatile b gfL;

    public static synchronized b bOM() {
        b bVar;
        synchronized (c.class) {
            if (gfL == null) {
                gfL = new b();
            }
            bVar = gfL;
        }
        return bVar;
    }
}
