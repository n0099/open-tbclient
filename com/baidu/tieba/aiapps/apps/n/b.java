package com.baidu.tieba.aiapps.apps.n;
/* loaded from: classes2.dex */
public class b {
    private static volatile a cWt;

    public static synchronized a azR() {
        a aVar;
        synchronized (b.class) {
            if (cWt == null) {
                cWt = new a();
            }
            aVar = cWt;
        }
        return aVar;
    }
}
