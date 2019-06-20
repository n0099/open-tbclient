package com.baidu.tieba.aiapps.apps.a;
/* loaded from: classes2.dex */
public class o {
    private static volatile n cZJ;

    public static synchronized n aDj() {
        n nVar;
        synchronized (o.class) {
            if (cZJ == null) {
                cZJ = new n();
            }
            nVar = cZJ;
        }
        return nVar;
    }
}
