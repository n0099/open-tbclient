package com.baidu.tieba.aiapps.apps.d;
/* loaded from: classes20.dex */
public class b {
    private static volatile a fRb;

    public static synchronized a bIA() {
        a aVar;
        synchronized (b.class) {
            if (fRb == null) {
                fRb = new a();
            }
            aVar = fRb;
        }
        return aVar;
    }
}
