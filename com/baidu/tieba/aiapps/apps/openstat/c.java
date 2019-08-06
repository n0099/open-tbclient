package com.baidu.tieba.aiapps.apps.openstat;
/* loaded from: classes2.dex */
public class c {
    private static volatile b dhi;

    public static synchronized b aGZ() {
        b bVar;
        synchronized (c.class) {
            if (dhi == null) {
                dhi = new b();
            }
            bVar = dhi;
        }
        return bVar;
    }
}
