package com.baidu.tieba.aiapps.apps.r;
/* loaded from: classes2.dex */
public class b {
    private static volatile a dhY;

    public static synchronized a aHM() {
        a aVar;
        synchronized (b.class) {
            if (dhY == null) {
                dhY = new a();
            }
            aVar = dhY;
        }
        return aVar;
    }
}
