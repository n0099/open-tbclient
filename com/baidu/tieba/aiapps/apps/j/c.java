package com.baidu.tieba.aiapps.apps.j;
/* loaded from: classes7.dex */
public class c {
    private static volatile b eGh;

    public static synchronized b bjk() {
        b bVar;
        synchronized (c.class) {
            if (eGh == null) {
                eGh = new b();
            }
            bVar = eGh;
        }
        return bVar;
    }
}
