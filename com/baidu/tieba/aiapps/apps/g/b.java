package com.baidu.tieba.aiapps.apps.g;
/* loaded from: classes2.dex */
public class b {
    private static volatile a dbz;

    public static synchronized a aEm() {
        a aVar;
        synchronized (b.class) {
            if (dbz == null) {
                dbz = new a();
            }
            aVar = dbz;
        }
        return aVar;
    }
}
