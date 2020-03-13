package com.baidu.tieba.aiapps.apps.media.b;
/* loaded from: classes7.dex */
public class e {
    private static volatile d eep;

    public static synchronized d aZX() {
        d dVar;
        synchronized (e.class) {
            if (eep == null) {
                eep = new d();
            }
            dVar = eep;
        }
        return dVar;
    }
}
