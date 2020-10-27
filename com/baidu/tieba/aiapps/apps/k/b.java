package com.baidu.tieba.aiapps.apps.k;
/* loaded from: classes20.dex */
public class b {
    private static volatile a fRG;

    public static synchronized a bJh() {
        a aVar;
        synchronized (b.class) {
            if (fRG == null) {
                fRG = new a();
            }
            aVar = fRG;
        }
        return aVar;
    }
}
