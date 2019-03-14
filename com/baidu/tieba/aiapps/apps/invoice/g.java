package com.baidu.tieba.aiapps.apps.invoice;
/* loaded from: classes2.dex */
public class g {
    private static volatile f cTq;

    public static synchronized f azi() {
        f fVar;
        synchronized (g.class) {
            if (cTq == null) {
                cTq = new f();
            }
            fVar = cTq;
        }
        return fVar;
    }
}
