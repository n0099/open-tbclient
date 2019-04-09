package com.baidu.tieba.aiapps.apps.k;
/* loaded from: classes2.dex */
public class c {
    private static volatile b cWc;

    public static synchronized b azI() {
        b bVar;
        synchronized (c.class) {
            if (cWc == null) {
                cWc = new b();
            }
            bVar = cWc;
        }
        return bVar;
    }
}
