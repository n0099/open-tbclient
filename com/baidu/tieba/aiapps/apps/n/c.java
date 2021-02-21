package com.baidu.tieba.aiapps.apps.n;
/* loaded from: classes7.dex */
public class c {
    private static volatile b gof;

    public static synchronized b bNX() {
        b bVar;
        synchronized (c.class) {
            if (gof == null) {
                gof = new b();
            }
            bVar = gof;
        }
        return bVar;
    }
}
