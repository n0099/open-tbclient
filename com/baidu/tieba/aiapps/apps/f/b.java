package com.baidu.tieba.aiapps.apps.f;
/* loaded from: classes5.dex */
public class b {
    private static volatile a dZI;

    public static synchronized a aXC() {
        a aVar;
        synchronized (b.class) {
            if (dZI == null) {
                dZI = new a();
            }
            aVar = dZI;
        }
        return aVar;
    }
}
