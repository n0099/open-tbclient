package com.baidu.tieba.aiapps.apps.b;
/* loaded from: classes7.dex */
public class c {
    private static volatile b edL;

    public static synchronized b aZN() {
        b bVar;
        synchronized (c.class) {
            if (edL == null) {
                edL = new b();
            }
            bVar = edL;
        }
        return bVar;
    }
}
