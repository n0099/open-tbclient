package com.baidu.tieba.aiapps.apps.j;
/* loaded from: classes14.dex */
public class b {
    private static volatile a ftR;

    public static synchronized a bDp() {
        a aVar;
        synchronized (b.class) {
            if (ftR == null) {
                ftR = new a();
            }
            aVar = ftR;
        }
        return aVar;
    }
}
