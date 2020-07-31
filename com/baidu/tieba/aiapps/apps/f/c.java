package com.baidu.tieba.aiapps.apps.f;
/* loaded from: classes14.dex */
public class c {
    private static volatile b fhU;

    public static synchronized b buh() {
        b bVar;
        synchronized (c.class) {
            if (fhU == null) {
                fhU = new b();
            }
            bVar = fhU;
        }
        return bVar;
    }
}
