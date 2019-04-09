package com.baidu.tieba.aiapps.apps.p;
/* loaded from: classes2.dex */
public class g {
    private static volatile f cWL;

    public static synchronized f aAb() {
        f fVar;
        synchronized (g.class) {
            if (cWL == null) {
                cWL = new f();
            }
            fVar = cWL;
        }
        return fVar;
    }
}
