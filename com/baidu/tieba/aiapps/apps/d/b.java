package com.baidu.tieba.aiapps.apps.d;
/* loaded from: classes7.dex */
public class b {
    private static volatile a eed;

    public static synchronized a aZT() {
        a aVar;
        synchronized (b.class) {
            if (eed == null) {
                eed = new a();
            }
            aVar = eed;
        }
        return aVar;
    }
}
