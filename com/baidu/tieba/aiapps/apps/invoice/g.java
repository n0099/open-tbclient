package com.baidu.tieba.aiapps.apps.invoice;
/* loaded from: classes2.dex */
public class g {
    private static volatile f doD;

    public static synchronized f aGF() {
        f fVar;
        synchronized (g.class) {
            if (doD == null) {
                doD = new f();
            }
            fVar = doD;
        }
        return fVar;
    }
}
