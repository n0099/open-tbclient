package com.baidu.tieba.aiapps.apps.f;
/* loaded from: classes7.dex */
public class b {
    private static volatile a edN;

    public static synchronized a aZT() {
        a aVar;
        synchronized (b.class) {
            if (edN == null) {
                edN = new a();
            }
            aVar = edN;
        }
        return aVar;
    }
}
