package com.baidu.tieba.aiapps.apps.d;
/* loaded from: classes19.dex */
public class b {
    private static volatile a fWy;

    public static synchronized a bKs() {
        a aVar;
        synchronized (b.class) {
            if (fWy == null) {
                fWy = new a();
            }
            aVar = fWy;
        }
        return aVar;
    }
}
