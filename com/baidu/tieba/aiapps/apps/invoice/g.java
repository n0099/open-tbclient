package com.baidu.tieba.aiapps.apps.invoice;
/* loaded from: classes2.dex */
public class g {
    private static volatile f cTu;

    public static synchronized f azj() {
        f fVar;
        synchronized (g.class) {
            if (cTu == null) {
                cTu = new f();
            }
            fVar = cTu;
        }
        return fVar;
    }
}
