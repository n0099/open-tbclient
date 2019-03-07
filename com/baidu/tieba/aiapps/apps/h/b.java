package com.baidu.tieba.aiapps.apps.h;
/* loaded from: classes2.dex */
public class b {
    private static volatile a cUX;

    public static synchronized a azv() {
        a aVar;
        synchronized (b.class) {
            if (cUX == null) {
                cUX = new a();
            }
            aVar = cUX;
        }
        return aVar;
    }
}
