package com.baidu.tieba.aiapps.apps.j;
/* loaded from: classes20.dex */
public class b {
    private static volatile a gfp;

    public static synchronized a bOG() {
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
