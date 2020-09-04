package com.baidu.tieba.aiapps.apps.e.a;
/* loaded from: classes14.dex */
public class b {
    private static volatile a ftr;

    public static synchronized a bCK() {
        a aVar;
        synchronized (b.class) {
            if (ftr == null) {
                ftr = new a();
            }
            aVar = ftr;
        }
        return aVar;
    }
}
