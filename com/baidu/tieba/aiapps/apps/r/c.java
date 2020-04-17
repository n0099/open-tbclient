package com.baidu.tieba.aiapps.apps.r;
/* loaded from: classes7.dex */
public class c {
    private static volatile b eGX;

    public static synchronized b bjB() {
        b bVar;
        synchronized (c.class) {
            if (eGX == null) {
                eGX = new b();
            }
            bVar = eGX;
        }
        return bVar;
    }
}
