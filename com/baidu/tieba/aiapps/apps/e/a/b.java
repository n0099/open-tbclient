package com.baidu.tieba.aiapps.apps.e.a;
/* loaded from: classes19.dex */
public class b {
    private static volatile a fWD;

    public static synchronized a bKt() {
        a aVar;
        synchronized (b.class) {
            if (fWD == null) {
                fWD = new a();
            }
            aVar = fWD;
        }
        return aVar;
    }
}
