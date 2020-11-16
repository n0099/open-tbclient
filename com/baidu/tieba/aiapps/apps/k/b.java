package com.baidu.tieba.aiapps.apps.k;
/* loaded from: classes19.dex */
public class b {
    private static volatile a fXd;

    public static synchronized a bKZ() {
        a aVar;
        synchronized (b.class) {
            if (fXd == null) {
                fXd = new a();
            }
            aVar = fXd;
        }
        return aVar;
    }
}
