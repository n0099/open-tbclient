package com.baidu.tieba.aiapps.apps.l;
/* loaded from: classes20.dex */
public class b {
    private static volatile a gfr;

    public static synchronized a bOJ() {
        a aVar;
        synchronized (b.class) {
            if (gfr == null) {
                gfr = new a();
            }
            aVar = gfr;
        }
        return aVar;
    }
}
