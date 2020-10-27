package com.baidu.tieba.aiapps.apps.f;
/* loaded from: classes20.dex */
public class c {
    private static volatile b fRl;

    public static synchronized b bIU() {
        b bVar;
        synchronized (c.class) {
            if (fRl == null) {
                fRl = new b();
            }
            bVar = fRl;
        }
        return bVar;
    }
}
