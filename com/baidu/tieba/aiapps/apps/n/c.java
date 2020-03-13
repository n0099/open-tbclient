package com.baidu.tieba.aiapps.apps.n;
/* loaded from: classes7.dex */
public class c {
    private static volatile b egv;

    public static synchronized b bbm() {
        b bVar;
        synchronized (c.class) {
            if (egv == null) {
                egv = new b();
            }
            bVar = egv;
        }
        return bVar;
    }
}
