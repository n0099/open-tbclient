package com.baidu.tieba.aiapps.apps.k;
/* loaded from: classes2.dex */
public class f {
    private static volatile e cWo;

    public static synchronized e azN() {
        e eVar;
        synchronized (f.class) {
            if (cWo == null) {
                cWo = new e();
            }
            eVar = cWo;
        }
        return eVar;
    }
}
