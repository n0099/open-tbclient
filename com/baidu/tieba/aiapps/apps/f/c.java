package com.baidu.tieba.aiapps.apps.f;
/* loaded from: classes20.dex */
public class c {
    private static volatile b fIQ;

    public static synchronized b bHb() {
        b bVar;
        synchronized (c.class) {
            if (fIQ == null) {
                fIQ = new b();
            }
            bVar = fIQ;
        }
        return bVar;
    }
}
