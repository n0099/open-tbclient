package com.baidu.tieba.aiapps.apps.media.b;
/* loaded from: classes2.dex */
public class e {
    private static volatile d cVj;

    public static synchronized d azy() {
        d dVar;
        synchronized (e.class) {
            if (cVj == null) {
                cVj = new d();
            }
            dVar = cVj;
        }
        return dVar;
    }
}
