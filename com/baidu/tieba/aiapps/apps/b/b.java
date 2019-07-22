package com.baidu.tieba.aiapps.apps.b;
/* loaded from: classes2.dex */
public class b {
    private static volatile a dbq;

    public static synchronized a aEA() {
        a aVar;
        synchronized (b.class) {
            if (dbq == null) {
                dbq = new a();
            }
            aVar = dbq;
        }
        return aVar;
    }
}
