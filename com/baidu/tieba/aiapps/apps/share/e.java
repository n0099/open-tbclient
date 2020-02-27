package com.baidu.tieba.aiapps.apps.share;
/* loaded from: classes7.dex */
public class e {
    private static volatile d egg;

    public static synchronized d bbh() {
        d dVar;
        synchronized (e.class) {
            if (egg == null) {
                egg = new d();
            }
            dVar = egg;
        }
        return dVar;
    }
}
