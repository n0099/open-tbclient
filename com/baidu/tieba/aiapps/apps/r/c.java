package com.baidu.tieba.aiapps.apps.r;
/* loaded from: classes7.dex */
public class c {
    private static volatile b egE;

    public static synchronized b bbt() {
        b bVar;
        synchronized (c.class) {
            if (egE == null) {
                egE = new b();
            }
            bVar = egE;
        }
        return bVar;
    }
}
