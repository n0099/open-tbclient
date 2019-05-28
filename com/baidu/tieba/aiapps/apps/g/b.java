package com.baidu.tieba.aiapps.apps.g;
/* loaded from: classes2.dex */
public class b {
    private static volatile a dbA;

    public static synchronized a aEp() {
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
