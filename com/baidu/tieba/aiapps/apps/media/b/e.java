package com.baidu.tieba.aiapps.apps.media.b;
/* loaded from: classes4.dex */
public class e {
    private static volatile d dZP;

    public static synchronized d aXl() {
        d dVar;
        synchronized (e.class) {
            if (dZP == null) {
                dZP = new d();
            }
            dVar = dZP;
        }
        return dVar;
    }
}
