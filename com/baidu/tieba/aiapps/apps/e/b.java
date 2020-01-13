package com.baidu.tieba.aiapps.apps.e;
/* loaded from: classes5.dex */
public class b {
    private static volatile a dZy;

    public static synchronized a aXz() {
        a aVar;
        synchronized (b.class) {
            if (dZy == null) {
                dZy = new a();
            }
            aVar = dZy;
        }
        return aVar;
    }
}
