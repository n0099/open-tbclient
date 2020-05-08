package com.baidu.tieba.aiapps.apps.barcode;
/* loaded from: classes7.dex */
public class c {
    private static volatile b eDQ;

    public static synchronized b bhQ() {
        b bVar;
        synchronized (c.class) {
            if (eDQ == null) {
                eDQ = new b();
            }
            bVar = eDQ;
        }
        return bVar;
    }
}
