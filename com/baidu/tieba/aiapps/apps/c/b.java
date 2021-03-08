package com.baidu.tieba.aiapps.apps.c;
/* loaded from: classes6.dex */
public class b {
    private static volatile a gnO;

    public static synchronized a bNn() {
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
