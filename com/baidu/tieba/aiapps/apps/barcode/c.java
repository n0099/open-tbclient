package com.baidu.tieba.aiapps.apps.barcode;
/* loaded from: classes7.dex */
public class c {
    private static volatile b eSt;

    public static synchronized b bob() {
        b bVar;
        synchronized (c.class) {
            if (eSt == null) {
                eSt = new b();
            }
            bVar = eSt;
        }
        return bVar;
    }
}
