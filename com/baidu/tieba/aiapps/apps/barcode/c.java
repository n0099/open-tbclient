package com.baidu.tieba.aiapps.apps.barcode;
/* loaded from: classes4.dex */
public class c {
    private static volatile b dZd;

    public static synchronized b aWY() {
        b bVar;
        synchronized (c.class) {
            if (dZd == null) {
                dZd = new b();
            }
            bVar = dZd;
        }
        return bVar;
    }
}
