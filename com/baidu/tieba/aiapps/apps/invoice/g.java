package com.baidu.tieba.aiapps.apps.invoice;
/* loaded from: classes2.dex */
public class g {
    private static volatile f cTt;

    public static synchronized f azf() {
        f fVar;
        synchronized (g.class) {
            if (cTt == null) {
                cTt = new f();
            }
            fVar = cTt;
        }
        return fVar;
    }
}
