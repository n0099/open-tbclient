package com.baidu.tieba.aiapps.apps.b;
/* loaded from: classes14.dex */
public class b {
    private static volatile a fsY;

    public static synchronized a bCE() {
        a aVar;
        synchronized (b.class) {
            if (fsY == null) {
                fsY = new a();
            }
            aVar = fsY;
        }
        return aVar;
    }
}
