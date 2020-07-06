package com.baidu.tieba.aiapps.apps.barcode;
/* loaded from: classes7.dex */
public class c {
    private static volatile b fcP;

    public static synchronized b bqE() {
        b bVar;
        synchronized (c.class) {
            if (fcP == null) {
                fcP = new b();
            }
            bVar = fcP;
        }
        return bVar;
    }
}
