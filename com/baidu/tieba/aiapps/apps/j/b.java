package com.baidu.tieba.aiapps.apps.j;
/* loaded from: classes14.dex */
public class b {
    private static volatile a ftN;

    public static synchronized a bDo() {
        a aVar;
        synchronized (b.class) {
            if (ftN == null) {
                ftN = new a();
            }
            aVar = ftN;
        }
        return aVar;
    }
}
