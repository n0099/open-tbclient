package com.baidu.tieba.aiapps.apps.l;
/* loaded from: classes2.dex */
public class c {
    private static volatile b dhq;

    public static synchronized b aHu() {
        b bVar;
        synchronized (c.class) {
            if (dhq == null) {
                dhq = new b();
            }
            bVar = dhq;
        }
        return bVar;
    }
}
