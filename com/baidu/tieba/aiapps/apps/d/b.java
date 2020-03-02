package com.baidu.tieba.aiapps.apps.d;
/* loaded from: classes7.dex */
public class b {
    private static volatile a edA;

    public static synchronized a aZO() {
        a aVar;
        synchronized (b.class) {
            if (edA == null) {
                edA = new a();
            }
            aVar = edA;
        }
        return aVar;
    }
}
