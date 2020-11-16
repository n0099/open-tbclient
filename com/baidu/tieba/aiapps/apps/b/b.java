package com.baidu.tieba.aiapps.apps.b;
/* loaded from: classes19.dex */
public class b {
    private static volatile a fWl;

    public static synchronized a bKn() {
        a aVar;
        synchronized (b.class) {
            if (fWl == null) {
                fWl = new a();
            }
            aVar = fWl;
        }
        return aVar;
    }
}
