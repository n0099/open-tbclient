package com.baidu.tieba.aiapps.apps.d;
/* loaded from: classes7.dex */
public class b {
    private static volatile a fdd;

    public static synchronized a bqK() {
        a aVar;
        synchronized (b.class) {
            if (fdd == null) {
                fdd = new a();
            }
            aVar = fdd;
        }
        return aVar;
    }
}
