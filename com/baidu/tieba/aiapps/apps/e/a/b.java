package com.baidu.tieba.aiapps.apps.e.a;
/* loaded from: classes20.dex */
public class b {
    private static volatile a fIL;

    public static synchronized a bGI() {
        a aVar;
        synchronized (b.class) {
            if (fIL == null) {
                fIL = new a();
            }
            aVar = fIL;
        }
        return aVar;
    }
}
