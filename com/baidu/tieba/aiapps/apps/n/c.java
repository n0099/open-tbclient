package com.baidu.tieba.aiapps.apps.n;
/* loaded from: classes20.dex */
public class c {
    private static volatile b gfN;

    public static synchronized b bON() {
        b bVar;
        synchronized (c.class) {
            if (gfN == null) {
                gfN = new b();
            }
            bVar = gfN;
        }
        return bVar;
    }
}
