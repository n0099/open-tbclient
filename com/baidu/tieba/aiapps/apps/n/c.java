package com.baidu.tieba.aiapps.apps.n;
/* loaded from: classes20.dex */
public class c {
    private static volatile b fJI;

    public static synchronized b bHt() {
        b bVar;
        synchronized (c.class) {
            if (fJI == null) {
                fJI = new b();
            }
            bVar = fJI;
        }
        return bVar;
    }
}
