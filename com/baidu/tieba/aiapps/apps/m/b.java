package com.baidu.tieba.aiapps.apps.m;
/* loaded from: classes2.dex */
public class b {
    private static volatile a dhz;

    public static synchronized a aHx() {
        a aVar;
        synchronized (b.class) {
            if (dhz == null) {
                dhz = new a();
            }
            aVar = dhz;
        }
        return aVar;
    }
}
