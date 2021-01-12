package com.baidu.tieba.aiapps.apps.d;
/* loaded from: classes6.dex */
public class b {
    private static volatile a gjt;

    public static synchronized a bMC() {
        a aVar;
        synchronized (b.class) {
            if (gjt == null) {
                gjt = new a();
            }
            aVar = gjt;
        }
        return aVar;
    }
}
