package com.baidu.tieba.aiapps.apps.p;
/* loaded from: classes2.dex */
public class g {
    private static volatile f cWM;

    public static synchronized f aAf() {
        f fVar;
        synchronized (g.class) {
            if (cWM == null) {
                cWM = new f();
            }
            fVar = cWM;
        }
        return fVar;
    }
}
