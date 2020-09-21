package com.baidu.tieba.aiapps.apps.j;
/* loaded from: classes19.dex */
public class b {
    private static volatile a fxb;

    public static synchronized a bEA() {
        a aVar;
        synchronized (b.class) {
            if (fxb == null) {
                fxb = new a();
            }
            aVar = fxb;
        }
        return aVar;
    }
}
