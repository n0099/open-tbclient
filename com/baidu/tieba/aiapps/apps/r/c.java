package com.baidu.tieba.aiapps.apps.r;
/* loaded from: classes7.dex */
public class c {
    private static volatile b egR;

    public static synchronized b bbu() {
        b bVar;
        synchronized (c.class) {
            if (egR == null) {
                egR = new b();
            }
            bVar = egR;
        }
        return bVar;
    }
}
