package com.baidu.tieba.aiapps.apps.c;
/* loaded from: classes7.dex */
public class b {
    private static volatile a edz;

    public static synchronized a aZN() {
        a aVar;
        synchronized (b.class) {
            if (edz == null) {
                edz = new a();
            }
            aVar = edz;
        }
        return aVar;
    }
}
