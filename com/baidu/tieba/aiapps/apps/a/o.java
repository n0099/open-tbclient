package com.baidu.tieba.aiapps.apps.a;
/* loaded from: classes2.dex */
public class o {
    private static volatile n ddb;

    public static synchronized n aFf() {
        n nVar;
        synchronized (o.class) {
            if (ddb == null) {
                ddb = new n();
            }
            nVar = ddb;
        }
        return nVar;
    }
}
