package com.baidu.tieba.aiapps.apps.d;
/* loaded from: classes7.dex */
public class b {
    private static volatile a gma;

    public static synchronized a bNd() {
        a aVar;
        synchronized (b.class) {
            if (gma == null) {
                gma = new a();
            }
            aVar = gma;
        }
        return aVar;
    }
}
