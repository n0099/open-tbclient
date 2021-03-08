package com.baidu.tieba.aiapps.apps.n;
/* loaded from: classes6.dex */
public class c {
    private static volatile b gpO;

    public static synchronized b bOd() {
        b bVar;
        synchronized (c.class) {
            if (gpO == null) {
                gpO = new b();
            }
            bVar = gpO;
        }
        return bVar;
    }
}
