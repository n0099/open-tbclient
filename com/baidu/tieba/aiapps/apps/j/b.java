package com.baidu.tieba.aiapps.apps.j;
/* loaded from: classes14.dex */
public class b {
    private static volatile a fiq;

    public static synchronized a but() {
        a aVar;
        synchronized (b.class) {
            if (fiq == null) {
                fiq = new a();
            }
            aVar = fiq;
        }
        return aVar;
    }
}
