package com.baidu.tieba.aiapps.apps.media.b;
/* loaded from: classes2.dex */
public class e {
    private static volatile d cVm;

    public static synchronized d azv() {
        d dVar;
        synchronized (e.class) {
            if (cVm == null) {
                cVm = new d();
            }
            dVar = cVm;
        }
        return dVar;
    }
}
