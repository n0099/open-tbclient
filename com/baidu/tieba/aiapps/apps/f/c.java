package com.baidu.tieba.aiapps.apps.f;
/* loaded from: classes20.dex */
public class c {
    private static volatile b geV;

    public static synchronized b bOv() {
        b bVar;
        synchronized (c.class) {
            if (geV == null) {
                geV = new b();
            }
            bVar = geV;
        }
        return bVar;
    }
}
