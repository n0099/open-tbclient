package com.baidu.tieba.aiapps.apps.e.a;
/* loaded from: classes7.dex */
public class b {
    private static volatile a gmt;

    public static synchronized a bNl() {
        a aVar;
        synchronized (b.class) {
            if (gmt == null) {
                gmt = new a();
            }
            aVar = gmt;
        }
        return aVar;
    }
}
