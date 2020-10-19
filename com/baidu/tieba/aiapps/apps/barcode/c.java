package com.baidu.tieba.aiapps.apps.barcode;
/* loaded from: classes20.dex */
public class c {
    private static volatile b fIs;

    public static synchronized b bGB() {
        b bVar;
        synchronized (c.class) {
            if (fIs == null) {
                fIs = new b();
            }
            bVar = fIs;
        }
        return bVar;
    }
}
