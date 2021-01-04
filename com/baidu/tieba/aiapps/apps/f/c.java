package com.baidu.tieba.aiapps.apps.f;
/* loaded from: classes7.dex */
public class c {
    private static volatile b gok;

    public static synchronized b bQN() {
        b bVar;
        synchronized (c.class) {
            if (gok == null) {
                gok = new b();
            }
            bVar = gok;
        }
        return bVar;
    }
}
