package com.baidu.tieba.aiapps.apps.e.a;
/* loaded from: classes19.dex */
public class b {
    private static volatile a fwC;

    public static synchronized a bDW() {
        a aVar;
        synchronized (b.class) {
            if (fwC == null) {
                fwC = new a();
            }
            aVar = fwC;
        }
        return aVar;
    }
}
