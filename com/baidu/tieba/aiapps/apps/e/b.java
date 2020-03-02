package com.baidu.tieba.aiapps.apps.e;
/* loaded from: classes7.dex */
public class b {
    private static volatile a edD;

    public static synchronized a aZQ() {
        a aVar;
        synchronized (b.class) {
            if (edD == null) {
                edD = new a();
            }
            aVar = edD;
        }
        return aVar;
    }
}
