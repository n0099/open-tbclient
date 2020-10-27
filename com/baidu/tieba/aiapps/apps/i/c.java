package com.baidu.tieba.aiapps.apps.i;
/* loaded from: classes20.dex */
public class c {
    private static volatile b fRE;

    public static synchronized b bJe() {
        b bVar;
        synchronized (c.class) {
            if (fRE == null) {
                fRE = new b();
            }
            bVar = fRE;
        }
        return bVar;
    }
}
