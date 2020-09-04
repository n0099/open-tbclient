package com.baidu.tieba.aiapps.apps.k;
/* loaded from: classes14.dex */
public class b {
    private static volatile a ftS;

    public static synchronized a bDq() {
        a aVar;
        synchronized (b.class) {
            if (ftS == null) {
                ftS = new a();
            }
            aVar = ftS;
        }
        return aVar;
    }
}
