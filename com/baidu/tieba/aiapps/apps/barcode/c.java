package com.baidu.tieba.aiapps.apps.barcode;
/* loaded from: classes2.dex */
public class c {
    private static volatile b dcW;

    public static synchronized b aFh() {
        b bVar;
        synchronized (c.class) {
            if (dcW == null) {
                dcW = new b();
            }
            bVar = dcW;
        }
        return bVar;
    }
}
