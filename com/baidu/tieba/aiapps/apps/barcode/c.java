package com.baidu.tieba.aiapps.apps.barcode;
/* loaded from: classes7.dex */
public class c {
    private static volatile b eSE;

    public static synchronized b bod() {
        b bVar;
        synchronized (c.class) {
            if (eSE == null) {
                eSE = new b();
            }
            bVar = eSE;
        }
        return bVar;
    }
}
