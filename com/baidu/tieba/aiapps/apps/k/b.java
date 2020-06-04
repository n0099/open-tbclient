package com.baidu.tieba.aiapps.apps.k;
/* loaded from: classes7.dex */
public class b {
    private static volatile a eTx;

    public static synchronized a boN() {
        a aVar;
        synchronized (b.class) {
            if (eTx == null) {
                eTx = new a();
            }
            aVar = eTx;
        }
        return aVar;
    }
}
