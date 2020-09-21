package com.baidu.tieba.aiapps.apps.d;
/* loaded from: classes19.dex */
public class b {
    private static volatile a fwx;

    public static synchronized a bDV() {
        a aVar;
        synchronized (b.class) {
            if (fwx == null) {
                fwx = new a();
            }
            aVar = fwx;
        }
        return aVar;
    }
}
