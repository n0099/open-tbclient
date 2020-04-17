package com.baidu.tieba.aiapps.apps.barcode;
/* loaded from: classes7.dex */
public class c {
    private static volatile b eDL;

    public static synchronized b bhS() {
        b bVar;
        synchronized (c.class) {
            if (eDL == null) {
                eDL = new b();
            }
            bVar = eDL;
        }
        return bVar;
    }
}
