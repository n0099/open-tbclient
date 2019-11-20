package com.baidu.tieba.aiapps.apps.openstat;
/* loaded from: classes2.dex */
public class c {
    private static volatile b drx;

    public static synchronized b aHO() {
        b bVar;
        synchronized (c.class) {
            if (drx == null) {
                drx = new b();
            }
            bVar = drx;
        }
        return bVar;
    }
}
