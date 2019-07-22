package com.baidu.tieba.aiapps.apps.barcode;
/* loaded from: classes2.dex */
public class c {
    private static volatile b dcP;

    public static synchronized b aFf() {
        b bVar;
        synchronized (c.class) {
            if (dcP == null) {
                dcP = new b();
            }
            bVar = dcP;
        }
        return bVar;
    }
}
