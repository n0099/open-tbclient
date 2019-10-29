package com.baidu.tieba.aiapps.apps.q;
/* loaded from: classes2.dex */
public class g {
    private static volatile f dte;

    public static synchronized f aIB() {
        f fVar;
        synchronized (g.class) {
            if (dte == null) {
                dte = new f();
            }
            fVar = dte;
        }
        return fVar;
    }
}
