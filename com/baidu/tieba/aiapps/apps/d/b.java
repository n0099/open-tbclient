package com.baidu.tieba.aiapps.apps.d;
/* loaded from: classes7.dex */
public class b {
    private static volatile a gmo;

    public static synchronized a bNk() {
        a aVar;
        synchronized (b.class) {
            if (gmo == null) {
                gmo = new a();
            }
            aVar = gmo;
        }
        return aVar;
    }
}
