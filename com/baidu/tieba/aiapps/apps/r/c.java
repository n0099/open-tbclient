package com.baidu.tieba.aiapps.apps.r;
/* loaded from: classes7.dex */
public class c {
    private static volatile b egD;

    public static synchronized b bbr() {
        b bVar;
        synchronized (c.class) {
            if (egD == null) {
                egD = new b();
            }
            bVar = egD;
        }
        return bVar;
    }
}
