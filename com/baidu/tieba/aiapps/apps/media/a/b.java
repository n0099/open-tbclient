package com.baidu.tieba.aiapps.apps.media.a;
/* loaded from: classes2.dex */
public class b {
    private static volatile a cVa;

    public static synchronized a azt() {
        a aVar;
        synchronized (b.class) {
            if (cVa == null) {
                cVa = new a();
            }
            aVar = cVa;
        }
        return aVar;
    }
}
