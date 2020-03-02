package com.baidu.tieba.aiapps.apps.barcode;
/* loaded from: classes7.dex */
public class c {
    private static volatile b edr;

    public static synchronized b aZJ() {
        b bVar;
        synchronized (c.class) {
            if (edr == null) {
                edr = new b();
            }
            bVar = edr;
        }
        return bVar;
    }
}
