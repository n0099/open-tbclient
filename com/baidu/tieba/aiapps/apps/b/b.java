package com.baidu.tieba.aiapps.apps.b;
/* loaded from: classes20.dex */
public class b {
    private static volatile a fWE;

    public static synchronized a bKU() {
        a aVar;
        synchronized (b.class) {
            if (fWE == null) {
                fWE = new a();
            }
            aVar = fWE;
        }
        return aVar;
    }
}
