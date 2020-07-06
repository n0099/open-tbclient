package com.baidu.tieba.aiapps.apps.m;
/* loaded from: classes7.dex */
public class c {
    private static volatile b fdV;

    public static synchronized b brs() {
        b bVar;
        synchronized (c.class) {
            if (fdV == null) {
                fdV = new b();
            }
            bVar = fdV;
        }
        return bVar;
    }
}
