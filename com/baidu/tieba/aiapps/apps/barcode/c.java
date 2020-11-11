package com.baidu.tieba.aiapps.apps.barcode;
/* loaded from: classes20.dex */
public class c {
    private static volatile b fWD;

    public static synchronized b bKT() {
        b bVar;
        synchronized (c.class) {
            if (fWD == null) {
                fWD = new b();
            }
            bVar = fWD;
        }
        return bVar;
    }
}
