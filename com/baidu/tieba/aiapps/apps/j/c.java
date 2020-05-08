package com.baidu.tieba.aiapps.apps.j;
/* loaded from: classes7.dex */
public class c {
    private static volatile b eGm;

    public static synchronized b bji() {
        b bVar;
        synchronized (c.class) {
            if (eGm == null) {
                eGm = new b();
            }
            bVar = eGm;
        }
        return bVar;
    }
}
