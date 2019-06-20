package com.baidu.tieba.aiapps.apps.b;
/* loaded from: classes2.dex */
public class b {
    private static volatile a cZR;

    public static synchronized a aDk() {
        a aVar;
        synchronized (b.class) {
            if (cZR == null) {
                cZR = new a();
            }
            aVar = cZR;
        }
        return aVar;
    }
}
