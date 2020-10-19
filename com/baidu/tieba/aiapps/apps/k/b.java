package com.baidu.tieba.aiapps.apps.k;
/* loaded from: classes20.dex */
public class b {
    private static volatile a fJl;

    public static synchronized a bHo() {
        a aVar;
        synchronized (b.class) {
            if (fJl == null) {
                fJl = new a();
            }
            aVar = fJl;
        }
        return aVar;
    }
}
