package com.baidu.tieba.aiapps.apps.d;
/* loaded from: classes20.dex */
public class b {
    private static volatile a geJ;

    public static synchronized a bOa() {
        a aVar;
        synchronized (b.class) {
            if (geJ == null) {
                geJ = new a();
            }
            aVar = geJ;
        }
        return aVar;
    }
}
