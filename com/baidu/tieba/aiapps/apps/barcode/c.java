package com.baidu.tieba.aiapps.apps.barcode;
/* loaded from: classes7.dex */
public class c {
    private static volatile b glN;

    public static synchronized b bMX() {
        b bVar;
        synchronized (c.class) {
            if (glN == null) {
                glN = new b();
            }
            bVar = glN;
        }
        return bVar;
    }
}
