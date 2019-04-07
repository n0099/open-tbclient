package com.baidu.tieba.aiapps.apps.p;
/* loaded from: classes2.dex */
public class g {
    private static volatile f cWK;

    public static synchronized f aAb() {
        f fVar;
        synchronized (g.class) {
            if (cWK == null) {
                cWK = new f();
            }
            fVar = cWK;
        }
        return fVar;
    }
}
