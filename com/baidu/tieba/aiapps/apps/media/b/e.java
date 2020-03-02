package com.baidu.tieba.aiapps.apps.media.b;
/* loaded from: classes7.dex */
public class e {
    private static volatile d eec;

    public static synchronized d aZW() {
        d dVar;
        synchronized (e.class) {
            if (eec == null) {
                eec = new d();
            }
            dVar = eec;
        }
        return dVar;
    }
}
