package com.baidu.tieba.aiapps.apps.b;
/* loaded from: classes2.dex */
public class b {
    private static volatile a cSO;

    public static synchronized a ayH() {
        a aVar;
        synchronized (b.class) {
            if (cSO == null) {
                cSO = new a();
            }
            aVar = cSO;
        }
        return aVar;
    }
}
