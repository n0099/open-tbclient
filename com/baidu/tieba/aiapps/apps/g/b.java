package com.baidu.tieba.aiapps.apps.g;
/* loaded from: classes2.dex */
public class b {
    private static volatile a deR;

    public static synchronized a aGa() {
        a aVar;
        synchronized (b.class) {
            if (deR == null) {
                deR = new a();
            }
            aVar = deR;
        }
        return aVar;
    }
}
