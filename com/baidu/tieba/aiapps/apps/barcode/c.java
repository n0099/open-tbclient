package com.baidu.tieba.aiapps.apps.barcode;
/* loaded from: classes20.dex */
public class c {
    private static volatile b gex;

    public static synchronized b bNV() {
        b bVar;
        synchronized (c.class) {
            if (gex == null) {
                gex = new b();
            }
            bVar = gex;
        }
        return bVar;
    }
}
