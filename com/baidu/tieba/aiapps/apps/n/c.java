package com.baidu.tieba.aiapps.apps.n;
/* loaded from: classes7.dex */
public class c {
    private static volatile b egi;

    public static synchronized b bbl() {
        b bVar;
        synchronized (c.class) {
            if (egi == null) {
                egi = new b();
            }
            bVar = egi;
        }
        return bVar;
    }
}
