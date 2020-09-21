package com.baidu.tieba.aiapps.apps.b;
/* loaded from: classes19.dex */
public class b {
    private static volatile a fwk;

    public static synchronized a bDQ() {
        a aVar;
        synchronized (b.class) {
            if (fwk == null) {
                fwk = new a();
            }
            aVar = fwk;
        }
        return aVar;
    }
}
