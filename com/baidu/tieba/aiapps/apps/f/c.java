package com.baidu.tieba.aiapps.apps.f;
/* loaded from: classes20.dex */
public class c {
    private static volatile b fXb;

    public static synchronized b bLt() {
        b bVar;
        synchronized (c.class) {
            if (fXb == null) {
                fXb = new b();
            }
            bVar = fXb;
        }
        return bVar;
    }
}
