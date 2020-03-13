package com.baidu.tieba.aiapps.apps.j;
/* loaded from: classes7.dex */
public class c {
    private static volatile b egb;

    public static synchronized b bbd() {
        b bVar;
        synchronized (c.class) {
            if (egb == null) {
                egb = new b();
            }
            bVar = egb;
        }
        return bVar;
    }
}
