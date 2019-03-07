package com.baidu.tieba.aiapps.apps.l;
/* loaded from: classes2.dex */
public class b {
    private static volatile a cWp;

    public static synchronized a azO() {
        a aVar;
        synchronized (b.class) {
            if (cWp == null) {
                cWp = new a();
            }
            aVar = cWp;
        }
        return aVar;
    }
}
