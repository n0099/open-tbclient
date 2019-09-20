package com.baidu.tieba.aiapps.apps.q;
/* loaded from: classes2.dex */
public class g {
    private static volatile f djK;

    public static synchronized f aIr() {
        f fVar;
        synchronized (g.class) {
            if (djK == null) {
                djK = new f();
            }
            fVar = djK;
        }
        return fVar;
    }
}
