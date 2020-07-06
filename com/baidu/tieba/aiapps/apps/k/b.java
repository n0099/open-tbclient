package com.baidu.tieba.aiapps.apps.k;
/* loaded from: classes7.dex */
public class b {
    private static volatile a fdI;

    public static synchronized a bro() {
        a aVar;
        synchronized (b.class) {
            if (fdI == null) {
                fdI = new a();
            }
            aVar = fdI;
        }
        return aVar;
    }
}
