package com.baidu.tieba.aiapps.apps.c;
/* loaded from: classes20.dex */
public class b {
    private static volatile a fQR;

    public static synchronized a bIx() {
        a aVar;
        synchronized (b.class) {
            if (fQR == null) {
                fQR = new a();
            }
            aVar = fQR;
        }
        return aVar;
    }
}
