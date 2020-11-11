package com.baidu.tieba.aiapps.apps.n;
/* loaded from: classes20.dex */
public class c {
    private static volatile b fXT;

    public static synchronized b bLL() {
        b bVar;
        synchronized (c.class) {
            if (fXT == null) {
                fXT = new b();
            }
            bVar = fXT;
        }
        return bVar;
    }
}
