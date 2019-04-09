package com.baidu.tieba.aiapps.apps.b;
/* loaded from: classes2.dex */
public class b {
    private static volatile a cSR;

    public static synchronized a ayE() {
        a aVar;
        synchronized (b.class) {
            if (cSR == null) {
                cSR = new a();
            }
            aVar = cSR;
        }
        return aVar;
    }
}
