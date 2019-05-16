package com.baidu.tieba.aiapps.apps.openstat;
/* loaded from: classes2.dex */
public class c {
    private static volatile b dfw;

    public static synchronized b aFy() {
        b bVar;
        synchronized (c.class) {
            if (dfw == null) {
                dfw = new b();
            }
            bVar = dfw;
        }
        return bVar;
    }
}
