package com.baidu.tieba.aiapps.apps.p;
/* loaded from: classes2.dex */
public class g {
    private static volatile f cWI;

    public static synchronized f aAe() {
        f fVar;
        synchronized (g.class) {
            if (cWI == null) {
                cWI = new f();
            }
            fVar = cWI;
        }
        return fVar;
    }
}
