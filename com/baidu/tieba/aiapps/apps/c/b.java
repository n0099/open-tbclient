package com.baidu.tieba.aiapps.apps.c;
/* loaded from: classes7.dex */
public class b {
    private static volatile a eSx;

    public static synchronized a boe() {
        a aVar;
        synchronized (b.class) {
            if (eSx == null) {
                eSx = new a();
            }
            aVar = eSx;
        }
        return aVar;
    }
}
