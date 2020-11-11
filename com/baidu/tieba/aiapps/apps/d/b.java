package com.baidu.tieba.aiapps.apps.d;
/* loaded from: classes20.dex */
public class b {
    private static volatile a fWR;

    public static synchronized a bKZ() {
        a aVar;
        synchronized (b.class) {
            if (fWR == null) {
                fWR = new a();
            }
            aVar = fWR;
        }
        return aVar;
    }
}
