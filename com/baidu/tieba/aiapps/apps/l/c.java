package com.baidu.tieba.aiapps.apps.l;
/* loaded from: classes2.dex */
public class c {
    private static volatile b dhx;

    public static synchronized b aHw() {
        b bVar;
        synchronized (c.class) {
            if (dhx == null) {
                dhx = new b();
            }
            bVar = dhx;
        }
        return bVar;
    }
}
