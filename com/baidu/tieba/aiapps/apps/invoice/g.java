package com.baidu.tieba.aiapps.apps.invoice;
/* loaded from: classes2.dex */
public class g {
    private static volatile f dfi;

    public static synchronized f aGs() {
        f fVar;
        synchronized (g.class) {
            if (dfi == null) {
                dfi = new f();
            }
            fVar = dfi;
        }
        return fVar;
    }
}
