package com.baidu.tieba.aiapps.apps.i;
/* loaded from: classes2.dex */
public class b {
    private static volatile a deX;

    public static synchronized a aGc() {
        a aVar;
        synchronized (b.class) {
            if (deX == null) {
                deX = new a();
            }
            aVar = deX;
        }
        return aVar;
    }
}
