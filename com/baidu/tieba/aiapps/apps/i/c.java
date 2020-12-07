package com.baidu.tieba.aiapps.apps.i;
/* loaded from: classes20.dex */
public class c {
    private static volatile b gfm;

    public static synchronized b bOE() {
        b bVar;
        synchronized (c.class) {
            if (gfm == null) {
                gfm = new b();
            }
            bVar = gfm;
        }
        return bVar;
    }
}
