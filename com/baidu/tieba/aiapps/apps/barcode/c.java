package com.baidu.tieba.aiapps.apps.barcode;
/* loaded from: classes19.dex */
public class c {
    private static volatile b fWk;

    public static synchronized b bKm() {
        b bVar;
        synchronized (c.class) {
            if (fWk == null) {
                fWk = new b();
            }
            bVar = fWk;
        }
        return bVar;
    }
}
