package com.baidu.tieba.aiapps.apps.b;
/* loaded from: classes7.dex */
public class c {
    private static volatile b eDS;

    public static synchronized b bhV() {
        b bVar;
        synchronized (c.class) {
            if (eDS == null) {
                eDS = new b();
            }
            bVar = eDS;
        }
        return bVar;
    }
}
