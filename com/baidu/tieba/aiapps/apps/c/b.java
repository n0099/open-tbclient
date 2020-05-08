package com.baidu.tieba.aiapps.apps.c;
/* loaded from: classes7.dex */
public class b {
    private static volatile a eDY;

    public static synchronized a bhU() {
        a aVar;
        synchronized (b.class) {
            if (eDY == null) {
                eDY = new a();
            }
            aVar = eDY;
        }
        return aVar;
    }
}
