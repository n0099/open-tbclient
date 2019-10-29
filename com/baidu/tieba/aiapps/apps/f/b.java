package com.baidu.tieba.aiapps.apps.f;
/* loaded from: classes2.dex */
public class b {
    private static volatile a dor;

    public static synchronized a aGy() {
        a aVar;
        synchronized (b.class) {
            if (dor == null) {
                dor = new a();
            }
            aVar = dor;
        }
        return aVar;
    }
}
