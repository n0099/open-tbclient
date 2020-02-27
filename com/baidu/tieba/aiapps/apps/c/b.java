package com.baidu.tieba.aiapps.apps.c;
/* loaded from: classes7.dex */
public class b {
    private static volatile a edy;

    public static synchronized a aZL() {
        a aVar;
        synchronized (b.class) {
            if (edy == null) {
                edy = new a();
            }
            aVar = edy;
        }
        return aVar;
    }
}
