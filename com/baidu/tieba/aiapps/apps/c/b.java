package com.baidu.tieba.aiapps.apps.c;
/* loaded from: classes7.dex */
public class b {
    private static volatile a edM;

    public static synchronized a aZO() {
        a aVar;
        synchronized (b.class) {
            if (edM == null) {
                edM = new a();
            }
            aVar = edM;
        }
        return aVar;
    }
}
