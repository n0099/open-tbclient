package com.baidu.tieba.aiapps.apps.k;
/* loaded from: classes2.dex */
public class c {
    private static volatile b cWb;

    public static synchronized b azI() {
        b bVar;
        synchronized (c.class) {
            if (cWb == null) {
                cWb = new b();
            }
            bVar = cWb;
        }
        return bVar;
    }
}
