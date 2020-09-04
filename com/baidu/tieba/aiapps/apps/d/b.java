package com.baidu.tieba.aiapps.apps.d;
/* loaded from: classes14.dex */
public class b {
    private static volatile a ftl;

    public static synchronized a bCJ() {
        a aVar;
        synchronized (b.class) {
            if (ftl == null) {
                ftl = new a();
            }
            aVar = ftl;
        }
        return aVar;
    }
}
