package com.baidu.tieba.aiapps.apps.d;
/* loaded from: classes14.dex */
public class b {
    private static volatile a fhK;

    public static synchronized a btN() {
        a aVar;
        synchronized (b.class) {
            if (fhK == null) {
                fhK = new a();
            }
            aVar = fhK;
        }
        return aVar;
    }
}
