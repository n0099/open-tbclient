package com.baidu.tieba.aiapps.apps.l;
/* loaded from: classes2.dex */
public class c {
    private static volatile b dsC;

    public static synchronized b aIk() {
        b bVar;
        synchronized (c.class) {
            if (dsC == null) {
                dsC = new b();
            }
            bVar = dsC;
        }
        return bVar;
    }
}
