package com.baidu.tieba.aiapps.apps.n;
/* loaded from: classes7.dex */
public class c {
    private static volatile b egL;

    public static synchronized b bbq() {
        b bVar;
        synchronized (c.class) {
            if (egL == null) {
                egL = new b();
            }
            bVar = egL;
        }
        return bVar;
    }
}
