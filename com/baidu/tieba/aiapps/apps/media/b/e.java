package com.baidu.tieba.aiapps.apps.media.b;
/* loaded from: classes7.dex */
public class e {
    private static volatile d eeF;

    public static synchronized d bab() {
        d dVar;
        synchronized (e.class) {
            if (eeF == null) {
                eeF = new d();
            }
            dVar = eeF;
        }
        return dVar;
    }
}
