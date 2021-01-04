package com.baidu.tieba.aiapps.apps.e.a;
/* loaded from: classes7.dex */
public class b {
    private static volatile a gof;

    public static synchronized a bQu() {
        a aVar;
        synchronized (b.class) {
            if (gof == null) {
                gof = new a();
            }
            aVar = gof;
        }
        return aVar;
    }
}
