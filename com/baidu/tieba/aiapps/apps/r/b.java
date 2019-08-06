package com.baidu.tieba.aiapps.apps.r;
/* loaded from: classes2.dex */
public class b {
    private static volatile a dif;

    public static synchronized a aHO() {
        a aVar;
        synchronized (b.class) {
            if (dif == null) {
                dif = new a();
            }
            aVar = dif;
        }
        return aVar;
    }
}
