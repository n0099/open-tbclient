package com.baidu.tieba.aiapps.apps.k;
/* loaded from: classes2.dex */
public class b {
    private static volatile a dhh;

    public static synchronized a aGY() {
        a aVar;
        synchronized (b.class) {
            if (dhh == null) {
                dhh = new a();
            }
            aVar = dhh;
        }
        return aVar;
    }
}
