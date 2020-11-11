package com.baidu.tieba.aiapps.apps.k;
/* loaded from: classes20.dex */
public class b {
    private static volatile a fXw;

    public static synchronized a bLG() {
        a aVar;
        synchronized (b.class) {
            if (fXw == null) {
                fXw = new a();
            }
            aVar = fXw;
        }
        return aVar;
    }
}
