package com.baidu.tieba.aiapps.apps.media.b;
/* loaded from: classes2.dex */
public class e {
    private static volatile d cVl;

    public static synchronized d azv() {
        d dVar;
        synchronized (e.class) {
            if (cVl == null) {
                cVl = new d();
            }
            dVar = cVl;
        }
        return dVar;
    }
}
