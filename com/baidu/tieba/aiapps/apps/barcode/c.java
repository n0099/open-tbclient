package com.baidu.tieba.aiapps.apps.barcode;
/* loaded from: classes6.dex */
public class c {
    private static volatile b gjg;

    public static synchronized b bMw() {
        b bVar;
        synchronized (c.class) {
            if (gjg == null) {
                gjg = new b();
            }
            bVar = gjg;
        }
        return bVar;
    }
}
