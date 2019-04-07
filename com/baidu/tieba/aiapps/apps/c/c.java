package com.baidu.tieba.aiapps.apps.c;
/* loaded from: classes2.dex */
public class c {
    private static volatile b cSY;

    public static synchronized b ayG() {
        b bVar;
        synchronized (c.class) {
            if (cSY == null) {
                cSY = new b();
            }
            bVar = cSY;
        }
        return bVar;
    }
}
