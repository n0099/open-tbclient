package com.baidu.tieba.aiapps.apps.g;
/* loaded from: classes2.dex */
public class b {
    private static volatile a deY;

    public static synchronized a aGc() {
        a aVar;
        synchronized (b.class) {
            if (deY == null) {
                deY = new a();
            }
            aVar = deY;
        }
        return aVar;
    }
}
