package com.baidu.tieba.aiapps.apps.e;
/* loaded from: classes7.dex */
public class b {
    private static volatile a edC;

    public static synchronized a aZO() {
        a aVar;
        synchronized (b.class) {
            if (edC == null) {
                edC = new a();
            }
            aVar = edC;
        }
        return aVar;
    }
}
