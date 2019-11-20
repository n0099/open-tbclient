package com.baidu.tieba.aiapps.apps.media.a;
/* loaded from: classes2.dex */
public class b {
    private static volatile a dpz;

    public static synchronized a aGU() {
        a aVar;
        synchronized (b.class) {
            if (dpz == null) {
                dpz = new a();
            }
            aVar = dpz;
        }
        return aVar;
    }
}
