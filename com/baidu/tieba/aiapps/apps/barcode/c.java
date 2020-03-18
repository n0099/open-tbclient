package com.baidu.tieba.aiapps.apps.barcode;
/* loaded from: classes7.dex */
public class c {
    private static volatile b edU;

    public static synchronized b aZO() {
        b bVar;
        synchronized (c.class) {
            if (edU == null) {
                edU = new b();
            }
            bVar = edU;
        }
        return bVar;
    }
}
