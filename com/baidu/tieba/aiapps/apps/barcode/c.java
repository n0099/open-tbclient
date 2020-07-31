package com.baidu.tieba.aiapps.apps.barcode;
/* loaded from: classes14.dex */
public class c {
    private static volatile b fhw;

    public static synchronized b btH() {
        b bVar;
        synchronized (c.class) {
            if (fhw == null) {
                fhw = new b();
            }
            bVar = fhw;
        }
        return bVar;
    }
}
