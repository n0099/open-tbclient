package com.baidu.tieba.aiapps.apps.abtest;
/* loaded from: classes2.dex */
public class b {
    private static volatile a cRb;

    public static synchronized a axY() {
        a aVar;
        synchronized (b.class) {
            if (cRb == null) {
                cRb = new a();
            }
            aVar = cRb;
        }
        return aVar;
    }
}
