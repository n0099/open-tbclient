package com.baidu.tieba.aiapps.apps.f;
/* loaded from: classes6.dex */
public class c {
    private static volatile b gjD;

    public static synchronized b bMW() {
        b bVar;
        synchronized (c.class) {
            if (gjD == null) {
                gjD = new b();
            }
            bVar = gjD;
        }
        return bVar;
    }
}
