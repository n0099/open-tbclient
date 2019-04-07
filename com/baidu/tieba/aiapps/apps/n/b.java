package com.baidu.tieba.aiapps.apps.n;
/* loaded from: classes2.dex */
public class b {
    private static volatile a cWv;

    public static synchronized a azO() {
        a aVar;
        synchronized (b.class) {
            if (cWv == null) {
                cWv = new a();
            }
            aVar = cWv;
        }
        return aVar;
    }
}
