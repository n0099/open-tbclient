package com.baidu.tieba.aiapps.apps.barcode;
/* loaded from: classes7.dex */
public class c {
    private static volatile b gnN;

    public static synchronized b bQn() {
        b bVar;
        synchronized (c.class) {
            if (gnN == null) {
                gnN = new b();
            }
            bVar = gnN;
        }
        return bVar;
    }
}
