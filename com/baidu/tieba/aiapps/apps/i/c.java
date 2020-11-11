package com.baidu.tieba.aiapps.apps.i;
/* loaded from: classes20.dex */
public class c {
    private static volatile b fXu;

    public static synchronized b bLD() {
        b bVar;
        synchronized (c.class) {
            if (fXu == null) {
                fXu = new b();
            }
            bVar = fXu;
        }
        return bVar;
    }
}
