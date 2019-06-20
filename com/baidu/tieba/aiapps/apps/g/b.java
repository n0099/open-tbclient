package com.baidu.tieba.aiapps.apps.g;
/* loaded from: classes2.dex */
public class b {
    private static volatile a dbB;

    public static synchronized a aEp() {
        a aVar;
        synchronized (b.class) {
            if (dbB == null) {
                dbB = new a();
            }
            aVar = dbB;
        }
        return aVar;
    }
}
