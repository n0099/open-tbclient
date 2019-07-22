package com.baidu.tieba.aiapps.apps.a;
/* loaded from: classes2.dex */
public class o {
    private static volatile n dbh;

    public static synchronized n aEz() {
        n nVar;
        synchronized (o.class) {
            if (dbh == null) {
                dbh = new n();
            }
            nVar = dbh;
        }
        return nVar;
    }
}
