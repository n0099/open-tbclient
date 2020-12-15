package com.baidu.tieba.aiapps.apps.e.a;
/* loaded from: classes20.dex */
public class b {
    private static volatile a geQ;

    public static synchronized a bOc() {
        a aVar;
        synchronized (b.class) {
            if (geQ == null) {
                geQ = new a();
            }
            aVar = geQ;
        }
        return aVar;
    }
}
