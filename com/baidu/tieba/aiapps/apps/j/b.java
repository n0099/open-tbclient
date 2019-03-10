package com.baidu.tieba.aiapps.apps.j;
/* loaded from: classes2.dex */
public class b {
    private static volatile a cVY;

    public static synchronized a azL() {
        a aVar;
        synchronized (b.class) {
            if (cVY == null) {
                cVY = new a();
            }
            aVar = cVY;
        }
        return aVar;
    }
}
