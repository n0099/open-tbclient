package com.baidu.tieba.aiapps.apps.barcode;
/* loaded from: classes14.dex */
public class c {
    private static volatile b fsT;

    public static synchronized b bCC() {
        b bVar;
        synchronized (c.class) {
            if (fsT == null) {
                fsT = new b();
            }
            bVar = fsT;
        }
        return bVar;
    }
}
