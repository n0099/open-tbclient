package com.baidu.tieba.aiapps.apps.j;
/* loaded from: classes19.dex */
public class b {
    private static volatile a fXc;

    public static synchronized a bKX() {
        a aVar;
        synchronized (b.class) {
            if (fXc == null) {
                fXc = new a();
            }
            aVar = fXc;
        }
        return aVar;
    }
}
