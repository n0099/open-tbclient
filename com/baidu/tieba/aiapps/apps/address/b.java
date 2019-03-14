package com.baidu.tieba.aiapps.apps.address;
/* loaded from: classes2.dex */
public class b {
    private static volatile a cRL;

    public static synchronized a aym() {
        a aVar;
        synchronized (b.class) {
            if (cRL == null) {
                cRL = new a();
            }
            aVar = cRL;
        }
        return aVar;
    }
}
