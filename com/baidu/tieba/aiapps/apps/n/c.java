package com.baidu.tieba.aiapps.apps.n;
/* loaded from: classes7.dex */
public class c {
    private static volatile b gnR;

    public static synchronized b bNQ() {
        b bVar;
        synchronized (c.class) {
            if (gnR == null) {
                gnR = new b();
            }
            bVar = gnR;
        }
        return bVar;
    }
}
