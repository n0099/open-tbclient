package com.baidu.tieba.aiapps.apps.f;
/* loaded from: classes7.dex */
public class c {
    private static volatile b gmy;

    public static synchronized b bNE() {
        b bVar;
        synchronized (c.class) {
            if (gmy == null) {
                gmy = new b();
            }
            bVar = gmy;
        }
        return bVar;
    }
}
