package com.baidu.tieba.aiapps.apps.k;
/* loaded from: classes2.dex */
public class c {
    private static volatile b cWd;

    public static synchronized b azM() {
        b bVar;
        synchronized (c.class) {
            if (cWd == null) {
                cWd = new b();
            }
            bVar = cWd;
        }
        return bVar;
    }
}
