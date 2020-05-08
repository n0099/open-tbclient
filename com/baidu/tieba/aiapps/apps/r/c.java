package com.baidu.tieba.aiapps.apps.r;
/* loaded from: classes7.dex */
public class c {
    private static volatile b eHc;

    public static synchronized b bjz() {
        b bVar;
        synchronized (c.class) {
            if (eHc == null) {
                eHc = new b();
            }
            bVar = eHc;
        }
        return bVar;
    }
}
