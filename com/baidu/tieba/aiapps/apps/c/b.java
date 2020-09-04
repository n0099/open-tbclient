package com.baidu.tieba.aiapps.apps.c;
/* loaded from: classes14.dex */
public class b {
    private static volatile a ftb;

    public static synchronized a bCG() {
        a aVar;
        synchronized (b.class) {
            if (ftb == null) {
                ftb = new a();
            }
            aVar = ftb;
        }
        return aVar;
    }
}
