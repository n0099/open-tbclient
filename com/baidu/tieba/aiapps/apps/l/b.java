package com.baidu.tieba.aiapps.apps.l;
/* loaded from: classes19.dex */
public class b {
    private static volatile a fxd;

    public static synchronized a bED() {
        a aVar;
        synchronized (b.class) {
            if (fxd == null) {
                fxd = new a();
            }
            aVar = fxd;
        }
        return aVar;
    }
}
