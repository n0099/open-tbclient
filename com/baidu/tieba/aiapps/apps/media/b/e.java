package com.baidu.tieba.aiapps.apps.media.b;
/* loaded from: classes7.dex */
public class e {
    private static volatile d eeb;

    public static synchronized d aZU() {
        d dVar;
        synchronized (e.class) {
            if (eeb == null) {
                eeb = new d();
            }
            dVar = eeb;
        }
        return dVar;
    }
}
