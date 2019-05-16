package com.baidu.tieba.aiapps.apps.h;
/* loaded from: classes2.dex */
public class b {
    private static volatile a ddn;

    public static synchronized a aEF() {
        a aVar;
        synchronized (b.class) {
            if (ddn == null) {
                ddn = new a();
            }
            aVar = ddn;
        }
        return aVar;
    }
}
