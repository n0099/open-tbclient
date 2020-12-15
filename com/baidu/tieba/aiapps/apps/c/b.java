package com.baidu.tieba.aiapps.apps.c;
/* loaded from: classes20.dex */
public class b {
    private static volatile a geB;

    public static synchronized a bNY() {
        a aVar;
        synchronized (b.class) {
            if (geB == null) {
                geB = new a();
            }
            aVar = geB;
        }
        return aVar;
    }
}
