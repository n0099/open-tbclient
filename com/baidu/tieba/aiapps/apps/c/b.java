package com.baidu.tieba.aiapps.apps.c;
/* loaded from: classes2.dex */
public class b {
    private static volatile a dbo;

    public static synchronized a aDP() {
        a aVar;
        synchronized (b.class) {
            if (dbo == null) {
                dbo = new a();
            }
            aVar = dbo;
        }
        return aVar;
    }
}
