package com.baidu.tieba.aiapps.apps.a;
/* loaded from: classes2.dex */
public class o {
    private static volatile n dmw;

    public static synchronized n aFr() {
        n nVar;
        synchronized (o.class) {
            if (dmw == null) {
                dmw = new n();
            }
            nVar = dmw;
        }
        return nVar;
    }
}
