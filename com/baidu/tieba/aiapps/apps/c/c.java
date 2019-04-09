package com.baidu.tieba.aiapps.apps.c;
/* loaded from: classes2.dex */
public class c {
    private static volatile b cSZ;

    public static synchronized b ayG() {
        b bVar;
        synchronized (c.class) {
            if (cSZ == null) {
                cSZ = new b();
            }
            bVar = cSZ;
        }
        return bVar;
    }
}
