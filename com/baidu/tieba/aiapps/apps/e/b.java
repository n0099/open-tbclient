package com.baidu.tieba.aiapps.apps.e;
/* loaded from: classes2.dex */
public class b {
    private static volatile a ddb;

    public static synchronized a aFE() {
        a aVar;
        synchronized (b.class) {
            if (ddb == null) {
                ddb = new a();
            }
            aVar = ddb;
        }
        return aVar;
    }
}
