package com.baidu.tieba.aiapps.apps.barcode;
/* loaded from: classes14.dex */
public class c {
    private static volatile b fsX;

    public static synchronized b bCD() {
        b bVar;
        synchronized (c.class) {
            if (fsX == null) {
                fsX = new b();
            }
            bVar = fsX;
        }
        return bVar;
    }
}
