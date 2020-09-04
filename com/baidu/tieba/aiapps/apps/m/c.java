package com.baidu.tieba.aiapps.apps.m;
/* loaded from: classes14.dex */
public class c {
    private static volatile b fuo;

    public static synchronized b bDu() {
        b bVar;
        synchronized (c.class) {
            if (fuo == null) {
                fuo = new b();
            }
            bVar = fuo;
        }
        return bVar;
    }
}
