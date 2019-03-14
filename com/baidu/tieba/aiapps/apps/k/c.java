package com.baidu.tieba.aiapps.apps.k;
/* loaded from: classes2.dex */
public class c {
    private static volatile b cVZ;

    public static synchronized b azL() {
        b bVar;
        synchronized (c.class) {
            if (cVZ == null) {
                cVZ = new b();
            }
            bVar = cVZ;
        }
        return bVar;
    }
}
