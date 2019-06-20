package com.baidu.tieba.aiapps.apps.f;
/* loaded from: classes2.dex */
public class b {
    private static volatile a dbA;

    public static synchronized a aEo() {
        a aVar;
        synchronized (b.class) {
            if (dbA == null) {
                dbA = new a();
            }
            aVar = dbA;
        }
        return aVar;
    }
}
