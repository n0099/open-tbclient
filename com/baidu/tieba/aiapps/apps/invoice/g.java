package com.baidu.tieba.aiapps.apps.invoice;
/* loaded from: classes2.dex */
public class g {
    private static volatile f cTs;

    public static synchronized f azf() {
        f fVar;
        synchronized (g.class) {
            if (cTs == null) {
                cTs = new f();
            }
            fVar = cTs;
        }
        return fVar;
    }
}
