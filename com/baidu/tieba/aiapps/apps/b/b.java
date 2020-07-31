package com.baidu.tieba.aiapps.apps.b;
/* loaded from: classes14.dex */
public class b {
    private static volatile a fhx;

    public static synchronized a btI() {
        a aVar;
        synchronized (b.class) {
            if (fhx == null) {
                fhx = new a();
            }
            aVar = fhx;
        }
        return aVar;
    }
}
