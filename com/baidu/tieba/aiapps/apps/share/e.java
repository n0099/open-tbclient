package com.baidu.tieba.aiapps.apps.share;
/* loaded from: classes2.dex */
public class e {
    private static volatile d djC;

    public static synchronized d aIh() {
        d dVar;
        synchronized (e.class) {
            if (djC == null) {
                djC = new d();
            }
            dVar = djC;
        }
        return dVar;
    }
}
