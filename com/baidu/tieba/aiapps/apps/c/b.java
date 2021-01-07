package com.baidu.tieba.aiapps.apps.c;
/* loaded from: classes7.dex */
public class b {
    private static volatile a gnR;

    public static synchronized a bQr() {
        a aVar;
        synchronized (b.class) {
            if (gnR == null) {
                gnR = new a();
            }
            aVar = gnR;
        }
        return aVar;
    }
}
