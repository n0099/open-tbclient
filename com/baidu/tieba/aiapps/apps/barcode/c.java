package com.baidu.tieba.aiapps.apps.barcode;
/* loaded from: classes7.dex */
public class c {
    private static volatile b edq;

    public static synchronized b aZH() {
        b bVar;
        synchronized (c.class) {
            if (edq == null) {
                edq = new b();
            }
            bVar = edq;
        }
        return bVar;
    }
}
