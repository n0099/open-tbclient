package com.baidu.tieba.aiapps.apps.n;
/* loaded from: classes20.dex */
public class c {
    private static volatile b fSd;

    public static synchronized b bJm() {
        b bVar;
        synchronized (c.class) {
            if (fSd == null) {
                fSd = new b();
            }
            bVar = fSd;
        }
        return bVar;
    }
}
