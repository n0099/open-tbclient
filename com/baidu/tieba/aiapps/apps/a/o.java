package com.baidu.tieba.aiapps.apps.a;
/* loaded from: classes2.dex */
public class o {
    private static volatile n dlF;

    public static synchronized n aFp() {
        n nVar;
        synchronized (o.class) {
            if (dlF == null) {
                dlF = new n();
            }
            nVar = dlF;
        }
        return nVar;
    }
}
