package com.baidu.tieba.aiapps.apps.h;
/* loaded from: classes2.dex */
public class b {
    private static volatile a dfc;

    public static synchronized a aGd() {
        a aVar;
        synchronized (b.class) {
            if (dfc == null) {
                dfc = new a();
            }
            aVar = dfc;
        }
        return aVar;
    }
}
