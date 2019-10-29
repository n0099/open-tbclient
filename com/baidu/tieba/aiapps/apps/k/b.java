package com.baidu.tieba.aiapps.apps.k;
/* loaded from: classes2.dex */
public class b {
    private static volatile a dsn;

    public static synchronized a aHP() {
        a aVar;
        synchronized (b.class) {
            if (dsn == null) {
                dsn = new a();
            }
            aVar = dsn;
        }
        return aVar;
    }
}
