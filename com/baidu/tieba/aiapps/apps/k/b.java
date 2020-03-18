package com.baidu.tieba.aiapps.apps.k;
/* loaded from: classes7.dex */
public class b {
    private static volatile a egu;

    public static synchronized a bbi() {
        a aVar;
        synchronized (b.class) {
            if (egu == null) {
                egu = new a();
            }
            aVar = egu;
        }
        return aVar;
    }
}
