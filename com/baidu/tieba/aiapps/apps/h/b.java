package com.baidu.tieba.aiapps.apps.h;
/* loaded from: classes2.dex */
public class b {
    private static volatile a dps;

    public static synchronized a aGS() {
        a aVar;
        synchronized (b.class) {
            if (dps == null) {
                dps = new a();
            }
            aVar = dps;
        }
        return aVar;
    }
}
