package com.baidu.tieba.aiapps.apps.k;
/* loaded from: classes2.dex */
public class f {
    private static volatile e cWn;

    public static synchronized e azK() {
        e eVar;
        synchronized (f.class) {
            if (cWn == null) {
                cWn = new e();
            }
            eVar = cWn;
        }
        return eVar;
    }
}
