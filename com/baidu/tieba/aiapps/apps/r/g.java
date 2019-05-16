package com.baidu.tieba.aiapps.apps.r;
/* loaded from: classes2.dex */
public class g {
    private static volatile f dgj;

    public static synchronized f aGm() {
        f fVar;
        synchronized (g.class) {
            if (dgj == null) {
                dgj = new f();
            }
            fVar = dgj;
        }
        return fVar;
    }
}
