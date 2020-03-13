package com.baidu.tieba.aiapps.apps.barcode;
/* loaded from: classes7.dex */
public class c {
    private static volatile b edE;

    public static synchronized b aZK() {
        b bVar;
        synchronized (c.class) {
            if (edE == null) {
                edE = new b();
            }
            bVar = edE;
        }
        return bVar;
    }
}
