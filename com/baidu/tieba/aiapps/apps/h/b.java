package com.baidu.tieba.aiapps.apps.h;
/* loaded from: classes2.dex */
public class b {
    private static volatile a ddo;

    public static synchronized a aEI() {
        a aVar;
        synchronized (b.class) {
            if (ddo == null) {
                ddo = new a();
            }
            aVar = ddo;
        }
        return aVar;
    }
}
