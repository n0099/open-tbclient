package com.baidu.tieba.aiapps.apps.k;
/* loaded from: classes2.dex */
public class f {
    private static volatile e cWm;

    public static synchronized e azK() {
        e eVar;
        synchronized (f.class) {
            if (cWm == null) {
                cWm = new e();
            }
            eVar = cWm;
        }
        return eVar;
    }
}
