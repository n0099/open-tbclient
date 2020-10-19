package com.baidu.tieba.aiapps.apps.b;
/* loaded from: classes20.dex */
public class b {
    private static volatile a fIt;

    public static synchronized a bGC() {
        a aVar;
        synchronized (b.class) {
            if (fIt == null) {
                fIt = new a();
            }
            aVar = fIt;
        }
        return aVar;
    }
}
