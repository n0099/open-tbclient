package com.baidu.tieba.aiapps.apps.b;
/* loaded from: classes6.dex */
public class b {
    private static volatile a gnL;

    public static synchronized a bNl() {
        a aVar;
        synchronized (b.class) {
            if (gnL == null) {
                gnL = new a();
            }
            aVar = gnL;
        }
        return aVar;
    }
}
