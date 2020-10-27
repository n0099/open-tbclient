package com.baidu.tieba.aiapps.apps.e.a;
/* loaded from: classes20.dex */
public class b {
    private static volatile a fRg;

    public static synchronized a bIB() {
        a aVar;
        synchronized (b.class) {
            if (fRg == null) {
                fRg = new a();
            }
            aVar = fRg;
        }
        return aVar;
    }
}
