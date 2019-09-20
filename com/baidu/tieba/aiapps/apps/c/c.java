package com.baidu.tieba.aiapps.apps.c;
/* loaded from: classes2.dex */
public class c {
    private static volatile b deR;

    public static synchronized b aFR() {
        b bVar;
        synchronized (c.class) {
            if (deR == null) {
                deR = new b();
            }
            bVar = deR;
        }
        return bVar;
    }
}
