package com.baidu.tieba.aiapps.apps.k;
/* loaded from: classes19.dex */
public class b {
    private static volatile a fxc;

    public static synchronized a bEC() {
        a aVar;
        synchronized (b.class) {
            if (fxc == null) {
                fxc = new a();
            }
            aVar = fxc;
        }
        return aVar;
    }
}
