package com.baidu.tieba.aiapps.apps.i;
/* loaded from: classes2.dex */
public class b {
    private static volatile a dql;

    public static synchronized a aGV() {
        a aVar;
        synchronized (b.class) {
            if (dql == null) {
                dql = new a();
            }
            aVar = dql;
        }
        return aVar;
    }
}
