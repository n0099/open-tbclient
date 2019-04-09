package com.baidu.tieba.aiapps.apps.g;
/* loaded from: classes2.dex */
public class b {
    private static volatile a cUU;

    public static synchronized a azr() {
        a aVar;
        synchronized (b.class) {
            if (cUU == null) {
                cUU = new a();
            }
            aVar = cUU;
        }
        return aVar;
    }
}
