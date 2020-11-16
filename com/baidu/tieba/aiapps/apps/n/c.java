package com.baidu.tieba.aiapps.apps.n;
/* loaded from: classes19.dex */
public class c {
    private static volatile b fXA;

    public static synchronized b bLe() {
        b bVar;
        synchronized (c.class) {
            if (fXA == null) {
                fXA = new b();
            }
            bVar = fXA;
        }
        return bVar;
    }
}
