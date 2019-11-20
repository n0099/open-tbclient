package com.baidu.tieba.aiapps.apps.invoice;
/* loaded from: classes2.dex */
public class g {
    private static volatile f dnL;

    public static synchronized f aGD() {
        f fVar;
        synchronized (g.class) {
            if (dnL == null) {
                dnL = new f();
            }
            fVar = dnL;
        }
        return fVar;
    }
}
