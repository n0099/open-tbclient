package com.baidu.tieba.aiapps.apps.address;
/* loaded from: classes2.dex */
public class b {
    private static volatile a daj;

    public static synchronized a aDu() {
        a aVar;
        synchronized (b.class) {
            if (daj == null) {
                daj = new a();
            }
            aVar = daj;
        }
        return aVar;
    }
}
