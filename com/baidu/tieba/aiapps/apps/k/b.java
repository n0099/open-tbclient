package com.baidu.tieba.aiapps.apps.k;
/* loaded from: classes14.dex */
public class b {
    private static volatile a fir;

    public static synchronized a buu() {
        a aVar;
        synchronized (b.class) {
            if (fir == null) {
                fir = new a();
            }
            aVar = fir;
        }
        return aVar;
    }
}
