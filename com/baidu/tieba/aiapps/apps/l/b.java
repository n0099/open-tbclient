package com.baidu.tieba.aiapps.apps.l;
/* loaded from: classes20.dex */
public class b {
    private static volatile a gfp;

    public static synchronized a bOI() {
        a aVar;
        synchronized (b.class) {
            if (gfp == null) {
                gfp = new a();
            }
            aVar = gfp;
        }
        return aVar;
    }
}
