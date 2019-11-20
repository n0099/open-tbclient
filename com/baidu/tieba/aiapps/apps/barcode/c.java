package com.baidu.tieba.aiapps.apps.barcode;
/* loaded from: classes2.dex */
public class c {
    private static volatile b dnl;

    public static synchronized b aFW() {
        b bVar;
        synchronized (c.class) {
            if (dnl == null) {
                dnl = new b();
            }
            bVar = dnl;
        }
        return bVar;
    }
}
