package com.baidu.tieba.aiapps.apps.barcode;
/* loaded from: classes20.dex */
public class c {
    private static volatile b gev;

    public static synchronized b bNU() {
        b bVar;
        synchronized (c.class) {
            if (gev == null) {
                gev = new b();
            }
            bVar = gev;
        }
        return bVar;
    }
}
