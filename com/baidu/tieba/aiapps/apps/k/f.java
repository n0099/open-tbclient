package com.baidu.tieba.aiapps.apps.k;
/* loaded from: classes2.dex */
public class f {
    private static volatile e cWk;

    public static synchronized e azN() {
        e eVar;
        synchronized (f.class) {
            if (cWk == null) {
                cWk = new e();
            }
            eVar = cWk;
        }
        return eVar;
    }
}
