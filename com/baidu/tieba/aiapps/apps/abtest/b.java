package com.baidu.tieba.aiapps.apps.abtest;
/* loaded from: classes2.dex */
public class b {
    private static volatile a dlt;

    public static synchronized a aFl() {
        a aVar;
        synchronized (b.class) {
            if (dlt == null) {
                dlt = new a();
            }
            aVar = dlt;
        }
        return aVar;
    }
}
