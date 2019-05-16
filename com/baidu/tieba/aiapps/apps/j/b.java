package com.baidu.tieba.aiapps.apps.j;
/* loaded from: classes2.dex */
public class b {
    private static volatile a ddt;

    public static synchronized a aEH() {
        a aVar;
        synchronized (b.class) {
            if (ddt == null) {
                ddt = new a();
            }
            aVar = ddt;
        }
        return aVar;
    }
}
