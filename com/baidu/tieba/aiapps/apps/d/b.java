package com.baidu.tieba.aiapps.apps.d;
/* loaded from: classes6.dex */
public class b {
    private static volatile a gnX;

    public static synchronized a bNq() {
        a aVar;
        synchronized (b.class) {
            if (gnX == null) {
                gnX = new a();
            }
            aVar = gnX;
        }
        return aVar;
    }
}
