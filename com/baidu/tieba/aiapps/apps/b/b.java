package com.baidu.tieba.aiapps.apps.b;
/* loaded from: classes7.dex */
public class b {
    private static volatile a gnO;

    public static synchronized a bQo() {
        a aVar;
        synchronized (b.class) {
            if (gnO == null) {
                gnO = new a();
            }
            aVar = gnO;
        }
        return aVar;
    }
}
