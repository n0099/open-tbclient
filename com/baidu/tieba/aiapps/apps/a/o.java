package com.baidu.tieba.aiapps.apps.a;
/* loaded from: classes2.dex */
public class o {
    private static volatile n cZH;

    public static synchronized n aDg() {
        n nVar;
        synchronized (o.class) {
            if (cZH == null) {
                cZH = new n();
            }
            nVar = cZH;
        }
        return nVar;
    }
}
