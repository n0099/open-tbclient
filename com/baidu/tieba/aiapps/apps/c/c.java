package com.baidu.tieba.aiapps.apps.c;
/* loaded from: classes2.dex */
public class c {
    private static volatile b cTa;

    public static synchronized b ayK() {
        b bVar;
        synchronized (c.class) {
            if (cTa == null) {
                cTa = new b();
            }
            bVar = cTa;
        }
        return bVar;
    }
}
