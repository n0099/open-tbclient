package com.baidu.tieba.aiapps.apps.o;
/* loaded from: classes2.dex */
public class c {
    private static volatile b dhB;

    public static synchronized b aHx() {
        b bVar;
        synchronized (c.class) {
            if (dhB == null) {
                dhB = new b();
            }
            bVar = dhB;
        }
        return bVar;
    }
}
