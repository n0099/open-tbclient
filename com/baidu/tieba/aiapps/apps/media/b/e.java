package com.baidu.tieba.aiapps.apps.media.b;
/* loaded from: classes2.dex */
public class e {
    private static volatile d cVn;

    public static synchronized d azy() {
        d dVar;
        synchronized (e.class) {
            if (cVn == null) {
                cVn = new d();
            }
            dVar = cVn;
        }
        return dVar;
    }
}
