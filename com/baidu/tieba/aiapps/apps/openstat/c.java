package com.baidu.tieba.aiapps.apps.openstat;
/* loaded from: classes2.dex */
public class c {
    private static volatile b dhb;

    public static synchronized b aGX() {
        b bVar;
        synchronized (c.class) {
            if (dhb == null) {
                dhb = new b();
            }
            bVar = dhb;
        }
        return bVar;
    }
}
