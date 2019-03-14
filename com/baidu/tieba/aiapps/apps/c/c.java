package com.baidu.tieba.aiapps.apps.c;
/* loaded from: classes2.dex */
public class c {
    private static volatile b cSW;

    public static synchronized b ayJ() {
        b bVar;
        synchronized (c.class) {
            if (cSW == null) {
                cSW = new b();
            }
            bVar = cSW;
        }
        return bVar;
    }
}
