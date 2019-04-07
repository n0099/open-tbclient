package com.baidu.tieba.aiapps.apps.b;
/* loaded from: classes2.dex */
public class b {
    private static volatile a cSQ;

    public static synchronized a ayE() {
        a aVar;
        synchronized (b.class) {
            if (cSQ == null) {
                cSQ = new a();
            }
            aVar = cSQ;
        }
        return aVar;
    }
}
