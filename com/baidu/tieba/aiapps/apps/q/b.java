package com.baidu.tieba.aiapps.apps.q;
/* loaded from: classes2.dex */
public class b {
    private static volatile a cWO;

    public static synchronized a aAf() {
        a aVar;
        synchronized (b.class) {
            if (cWO == null) {
                cWO = new a();
            }
            aVar = cWO;
        }
        return aVar;
    }
}
