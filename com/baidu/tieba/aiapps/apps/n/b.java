package com.baidu.tieba.aiapps.apps.n;
/* loaded from: classes2.dex */
public class b {
    private static volatile a cWw;

    public static synchronized a azO() {
        a aVar;
        synchronized (b.class) {
            if (cWw == null) {
                cWw = new a();
            }
            aVar = cWw;
        }
        return aVar;
    }
}
