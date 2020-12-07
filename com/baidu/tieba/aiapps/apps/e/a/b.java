package com.baidu.tieba.aiapps.apps.e.a;
/* loaded from: classes20.dex */
public class b {
    private static volatile a geO;

    public static synchronized a bOb() {
        a aVar;
        synchronized (b.class) {
            if (geO == null) {
                geO = new a();
            }
            aVar = geO;
        }
        return aVar;
    }
}
