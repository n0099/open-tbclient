package com.baidu.tieba.aiapps.apps.f;
/* loaded from: classes2.dex */
public class b {
    private static volatile a dby;

    public static synchronized a aEl() {
        a aVar;
        synchronized (b.class) {
            if (dby == null) {
                dby = new a();
            }
            aVar = dby;
        }
        return aVar;
    }
}
