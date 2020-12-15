package com.baidu.tieba.aiapps.apps.k;
/* loaded from: classes20.dex */
public class b {
    private static volatile a gfq;

    public static synchronized a bOI() {
        a aVar;
        synchronized (b.class) {
            if (gfq == null) {
                gfq = new a();
            }
            aVar = gfq;
        }
        return aVar;
    }
}
