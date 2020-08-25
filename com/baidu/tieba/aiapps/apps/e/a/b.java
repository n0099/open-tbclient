package com.baidu.tieba.aiapps.apps.e.a;
/* loaded from: classes14.dex */
public class b {
    private static volatile a ftm;

    public static synchronized a bCJ() {
        a aVar;
        synchronized (b.class) {
            if (ftm == null) {
                ftm = new a();
            }
            aVar = ftm;
        }
        return aVar;
    }
}
