package com.baidu.tieba.aiapps.apps.e;
/* loaded from: classes2.dex */
public class b {
    private static volatile a cSY;

    public static synchronized a azb() {
        a aVar;
        synchronized (b.class) {
            if (cSY == null) {
                cSY = new a();
            }
            aVar = cSY;
        }
        return aVar;
    }
}
