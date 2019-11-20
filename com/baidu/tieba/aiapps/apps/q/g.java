package com.baidu.tieba.aiapps.apps.q;
/* loaded from: classes2.dex */
public class g {
    private static volatile f dsm;

    public static synchronized f aIz() {
        f fVar;
        synchronized (g.class) {
            if (dsm == null) {
                dsm = new f();
            }
            fVar = dsm;
        }
        return fVar;
    }
}
