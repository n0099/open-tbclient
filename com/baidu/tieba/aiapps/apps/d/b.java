package com.baidu.tieba.aiapps.apps.d;
/* loaded from: classes7.dex */
public class b {
    private static volatile a goa;

    public static synchronized a bQt() {
        a aVar;
        synchronized (b.class) {
            if (goa == null) {
                goa = new a();
            }
            aVar = goa;
        }
        return aVar;
    }
}
