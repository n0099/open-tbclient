package com.baidu.tieba.aiapps.apps.j;
/* loaded from: classes7.dex */
public class c {
    private static volatile b egr;

    public static synchronized b bbh() {
        b bVar;
        synchronized (c.class) {
            if (egr == null) {
                egr = new b();
            }
            bVar = egr;
        }
        return bVar;
    }
}
