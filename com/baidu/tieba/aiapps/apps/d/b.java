package com.baidu.tieba.aiapps.apps.d;
/* loaded from: classes20.dex */
public class b {
    private static volatile a fIG;

    public static synchronized a bGH() {
        a aVar;
        synchronized (b.class) {
            if (fIG == null) {
                fIG = new a();
            }
            aVar = fIG;
        }
        return aVar;
    }
}
