package com.baidu.tieba.aiapps.apps.d;
/* loaded from: classes20.dex */
public class b {
    private static volatile a geL;

    public static synchronized a bOb() {
        a aVar;
        synchronized (b.class) {
            if (geL == null) {
                geL = new a();
            }
            aVar = geL;
        }
        return aVar;
    }
}
