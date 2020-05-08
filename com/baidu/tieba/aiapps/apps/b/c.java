package com.baidu.tieba.aiapps.apps.b;
/* loaded from: classes7.dex */
public class c {
    private static volatile b eDX;

    public static synchronized b bhT() {
        b bVar;
        synchronized (c.class) {
            if (eDX == null) {
                eDX = new b();
            }
            bVar = eDX;
        }
        return bVar;
    }
}
