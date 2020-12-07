package com.baidu.tieba.aiapps.apps.b;
/* loaded from: classes20.dex */
public class b {
    private static volatile a gew;

    public static synchronized a bNV() {
        a aVar;
        synchronized (b.class) {
            if (gew == null) {
                gew = new a();
            }
            aVar = gew;
        }
        return aVar;
    }
}
