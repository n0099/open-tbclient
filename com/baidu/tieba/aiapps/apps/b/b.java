package com.baidu.tieba.aiapps.apps.b;
/* loaded from: classes20.dex */
public class b {
    private static volatile a gey;

    public static synchronized a bNW() {
        a aVar;
        synchronized (b.class) {
            if (gey == null) {
                gey = new a();
            }
            aVar = gey;
        }
        return aVar;
    }
}
