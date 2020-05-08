package com.baidu.tieba.aiapps.apps.n;
/* loaded from: classes7.dex */
public class c {
    private static volatile b eGG;

    public static synchronized b bjr() {
        b bVar;
        synchronized (c.class) {
            if (eGG == null) {
                eGG = new b();
            }
            bVar = eGG;
        }
        return bVar;
    }
}
