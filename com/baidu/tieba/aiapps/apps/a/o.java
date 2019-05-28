package com.baidu.tieba.aiapps.apps.a;
/* loaded from: classes2.dex */
public class o {
    private static volatile n cZI;

    public static synchronized n aDj() {
        n nVar;
        synchronized (o.class) {
            if (cZI == null) {
                cZI = new n();
            }
            nVar = cZI;
        }
        return nVar;
    }
}
