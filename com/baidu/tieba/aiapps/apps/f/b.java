package com.baidu.tieba.aiapps.apps.f;
/* loaded from: classes2.dex */
public class b {
    private static volatile a dbz;

    public static synchronized a aEo() {
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
