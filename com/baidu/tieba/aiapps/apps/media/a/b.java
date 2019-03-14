package com.baidu.tieba.aiapps.apps.media.a;
/* loaded from: classes2.dex */
public class b {
    private static volatile a cUY;

    public static synchronized a azw() {
        a aVar;
        synchronized (b.class) {
            if (cUY == null) {
                cUY = new a();
            }
            aVar = cUY;
        }
        return aVar;
    }
}
