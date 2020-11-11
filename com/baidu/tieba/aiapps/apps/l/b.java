package com.baidu.tieba.aiapps.apps.l;
/* loaded from: classes20.dex */
public class b {
    private static volatile a fXx;

    public static synchronized a bLH() {
        a aVar;
        synchronized (b.class) {
            if (fXx == null) {
                fXx = new a();
            }
            aVar = fXx;
        }
        return aVar;
    }
}
