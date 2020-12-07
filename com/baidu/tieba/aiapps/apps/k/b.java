package com.baidu.tieba.aiapps.apps.k;
/* loaded from: classes20.dex */
public class b {
    private static volatile a gfo;

    public static synchronized a bOH() {
        a aVar;
        synchronized (b.class) {
            if (gfo == null) {
                gfo = new a();
            }
            aVar = gfo;
        }
        return aVar;
    }
}
