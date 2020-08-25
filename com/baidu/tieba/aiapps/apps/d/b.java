package com.baidu.tieba.aiapps.apps.d;
/* loaded from: classes14.dex */
public class b {
    private static volatile a fth;

    public static synchronized a bCI() {
        a aVar;
        synchronized (b.class) {
            if (fth == null) {
                fth = new a();
            }
            aVar = fth;
        }
        return aVar;
    }
}
