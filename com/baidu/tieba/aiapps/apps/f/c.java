package com.baidu.tieba.aiapps.apps.f;
/* loaded from: classes7.dex */
public class c {
    private static volatile b fdn;

    public static synchronized b brd() {
        b bVar;
        synchronized (c.class) {
            if (fdn == null) {
                fdn = new b();
            }
            bVar = fdn;
        }
        return bVar;
    }
}
