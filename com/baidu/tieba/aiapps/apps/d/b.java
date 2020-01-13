package com.baidu.tieba.aiapps.apps.d;
/* loaded from: classes5.dex */
public class b {
    private static volatile a dZv;

    public static synchronized a aXx() {
        a aVar;
        synchronized (b.class) {
            if (dZv == null) {
                dZv = new a();
            }
            aVar = dZv;
        }
        return aVar;
    }
}
