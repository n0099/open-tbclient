package com.baidu.tieba.aiapps.apps.n;
/* loaded from: classes7.dex */
public class c {
    private static volatile b gpS;

    public static synchronized b bRg() {
        b bVar;
        synchronized (c.class) {
            if (gpS == null) {
                gpS = new b();
            }
            bVar = gpS;
        }
        return bVar;
    }
}
