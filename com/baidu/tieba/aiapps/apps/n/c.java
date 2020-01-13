package com.baidu.tieba.aiapps.apps.n;
/* loaded from: classes5.dex */
public class c {
    private static volatile b ece;

    public static synchronized b aYU() {
        b bVar;
        synchronized (c.class) {
            if (ece == null) {
                ece = new b();
            }
            bVar = ece;
        }
        return bVar;
    }
}
