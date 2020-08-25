package com.baidu.tieba.aiapps.apps.k;
/* loaded from: classes14.dex */
public class b {
    private static volatile a ftO;

    public static synchronized a bDp() {
        a aVar;
        synchronized (b.class) {
            if (ftO == null) {
                ftO = new a();
            }
            aVar = ftO;
        }
        return aVar;
    }
}
