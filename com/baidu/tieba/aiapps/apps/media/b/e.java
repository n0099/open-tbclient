package com.baidu.tieba.aiapps.apps.media.b;
/* loaded from: classes7.dex */
public class e {
    private static volatile d eEB;

    public static synchronized d bid() {
        d dVar;
        synchronized (e.class) {
            if (eEB == null) {
                eEB = new d();
            }
            dVar = eEB;
        }
        return dVar;
    }
}
