package com.baidu.tieba.aiapps.apps.n;
/* loaded from: classes7.dex */
public class c {
    private static volatile b eGB;

    public static synchronized b bjt() {
        b bVar;
        synchronized (c.class) {
            if (eGB == null) {
                eGB = new b();
            }
            bVar = eGB;
        }
        return bVar;
    }
}
