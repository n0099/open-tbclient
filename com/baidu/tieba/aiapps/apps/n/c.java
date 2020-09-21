package com.baidu.tieba.aiapps.apps.n;
/* loaded from: classes19.dex */
public class c {
    private static volatile b fxz;

    public static synchronized b bEH() {
        b bVar;
        synchronized (c.class) {
            if (fxz == null) {
                fxz = new b();
            }
            bVar = fxz;
        }
        return bVar;
    }
}
