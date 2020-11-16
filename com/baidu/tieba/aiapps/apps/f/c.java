package com.baidu.tieba.aiapps.apps.f;
/* loaded from: classes19.dex */
public class c {
    private static volatile b fWI;

    public static synchronized b bKM() {
        b bVar;
        synchronized (c.class) {
            if (fWI == null) {
                fWI = new b();
            }
            bVar = fWI;
        }
        return bVar;
    }
}
