package com.baidu.tieba.aiapps.apps.c;
/* loaded from: classes5.dex */
public class b {
    private static volatile a dZu;

    public static synchronized a aXw() {
        a aVar;
        synchronized (b.class) {
            if (dZu == null) {
                dZu = new a();
            }
            aVar = dZu;
        }
        return aVar;
    }
}
