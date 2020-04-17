package com.baidu.tieba.aiapps.apps.share;
/* loaded from: classes7.dex */
public class e {
    private static volatile d eGA;

    public static synchronized d bjr() {
        d dVar;
        synchronized (e.class) {
            if (eGA == null) {
                eGA = new d();
            }
            dVar = eGA;
        }
        return dVar;
    }
}
