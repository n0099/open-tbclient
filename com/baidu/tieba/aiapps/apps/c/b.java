package com.baidu.tieba.aiapps.apps.c;
/* loaded from: classes20.dex */
public class b {
    private static volatile a gez;

    public static synchronized a bNX() {
        a aVar;
        synchronized (b.class) {
            if (gez == null) {
                gez = new a();
            }
            aVar = gez;
        }
        return aVar;
    }
}
