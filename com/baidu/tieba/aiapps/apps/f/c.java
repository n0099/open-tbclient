package com.baidu.tieba.aiapps.apps.f;
/* loaded from: classes6.dex */
public class c {
    private static volatile b goh;

    public static synchronized b bNK() {
        b bVar;
        synchronized (c.class) {
            if (goh == null) {
                goh = new b();
            }
            bVar = goh;
        }
        return bVar;
    }
}
