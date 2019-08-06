package com.baidu.tieba.aiapps.apps.a;
/* loaded from: classes2.dex */
public class o {
    private static volatile n dbo;

    public static synchronized n aEB() {
        n nVar;
        synchronized (o.class) {
            if (dbo == null) {
                dbo = new n();
            }
            nVar = dbo;
        }
        return nVar;
    }
}
