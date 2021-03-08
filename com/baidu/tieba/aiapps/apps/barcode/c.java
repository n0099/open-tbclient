package com.baidu.tieba.aiapps.apps.barcode;
/* loaded from: classes6.dex */
public class c {
    private static volatile b gnK;

    public static synchronized b bNk() {
        b bVar;
        synchronized (c.class) {
            if (gnK == null) {
                gnK = new b();
            }
            bVar = gnK;
        }
        return bVar;
    }
}
