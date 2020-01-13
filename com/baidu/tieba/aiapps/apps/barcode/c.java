package com.baidu.tieba.aiapps.apps.barcode;
/* loaded from: classes5.dex */
public class c {
    private static volatile b dZm;

    public static synchronized b aXs() {
        b bVar;
        synchronized (c.class) {
            if (dZm == null) {
                dZm = new b();
            }
            bVar = dZm;
        }
        return bVar;
    }
}
