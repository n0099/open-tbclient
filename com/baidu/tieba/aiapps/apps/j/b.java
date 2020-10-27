package com.baidu.tieba.aiapps.apps.j;
/* loaded from: classes20.dex */
public class b {
    private static volatile a fRF;

    public static synchronized a bJf() {
        a aVar;
        synchronized (b.class) {
            if (fRF == null) {
                fRF = new a();
            }
            aVar = fRF;
        }
        return aVar;
    }
}
