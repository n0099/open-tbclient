package com.baidu.tieba.aiapps.apps.b;
/* loaded from: classes7.dex */
public class c {
    private static volatile b edx;

    public static synchronized b aZK() {
        b bVar;
        synchronized (c.class) {
            if (edx == null) {
                edx = new b();
            }
            bVar = edx;
        }
        return bVar;
    }
}
