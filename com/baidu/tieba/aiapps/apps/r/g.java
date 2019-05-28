package com.baidu.tieba.aiapps.apps.r;
/* loaded from: classes2.dex */
public class g {
    private static volatile f dgk;

    public static synchronized f aGp() {
        f fVar;
        synchronized (g.class) {
            if (dgk == null) {
                dgk = new f();
            }
            fVar = dgk;
        }
        return fVar;
    }
}
