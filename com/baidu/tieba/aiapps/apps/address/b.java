package com.baidu.tieba.aiapps.apps.address;
/* loaded from: classes2.dex */
public class b {
    private static volatile a dbI;

    public static synchronized a aEK() {
        a aVar;
        synchronized (b.class) {
            if (dbI == null) {
                dbI = new a();
            }
            aVar = dbI;
        }
        return aVar;
    }
}
