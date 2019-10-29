package com.baidu.tieba.aiapps.apps.barcode;
/* loaded from: classes2.dex */
public class c {
    private static volatile b doe;

    public static synchronized b aFY() {
        b bVar;
        synchronized (c.class) {
            if (doe == null) {
                doe = new b();
            }
            bVar = doe;
        }
        return bVar;
    }
}
