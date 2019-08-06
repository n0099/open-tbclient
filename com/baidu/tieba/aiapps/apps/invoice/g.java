package com.baidu.tieba.aiapps.apps.invoice;
/* loaded from: classes2.dex */
public class g {
    private static volatile f ddw;

    public static synchronized f aFO() {
        f fVar;
        synchronized (g.class) {
            if (ddw == null) {
                ddw = new f();
            }
            fVar = ddw;
        }
        return fVar;
    }
}
