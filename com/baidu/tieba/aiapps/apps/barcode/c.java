package com.baidu.tieba.aiapps.apps.barcode;
/* loaded from: classes7.dex */
public class c {
    private static volatile b gmb;

    public static synchronized b bNe() {
        b bVar;
        synchronized (c.class) {
            if (gmb == null) {
                gmb = new b();
            }
            bVar = gmb;
        }
        return bVar;
    }
}
