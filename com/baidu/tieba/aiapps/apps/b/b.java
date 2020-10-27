package com.baidu.tieba.aiapps.apps.b;
/* loaded from: classes20.dex */
public class b {
    private static volatile a fQO;

    public static synchronized a bIv() {
        a aVar;
        synchronized (b.class) {
            if (fQO == null) {
                fQO = new a();
            }
            aVar = fQO;
        }
        return aVar;
    }
}
