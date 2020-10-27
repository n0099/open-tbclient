package com.baidu.tieba.aiapps.apps.l;
/* loaded from: classes20.dex */
public class b {
    private static volatile a fRH;

    public static synchronized a bJi() {
        a aVar;
        synchronized (b.class) {
            if (fRH == null) {
                fRH = new a();
            }
            aVar = fRH;
        }
        return aVar;
    }
}
