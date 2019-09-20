package com.baidu.tieba.aiapps.apps.k;
/* loaded from: classes2.dex */
public class b {
    private static volatile a diS;

    public static synchronized a aHC() {
        a aVar;
        synchronized (b.class) {
            if (diS == null) {
                diS = new a();
            }
            aVar = diS;
        }
        return aVar;
    }
}
