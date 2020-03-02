package com.baidu.tieba.aiapps.apps.b;
/* loaded from: classes7.dex */
public class c {
    private static volatile b edy;

    public static synchronized b aZM() {
        b bVar;
        synchronized (c.class) {
            if (edy == null) {
                edy = new b();
            }
            bVar = edy;
        }
        return bVar;
    }
}
