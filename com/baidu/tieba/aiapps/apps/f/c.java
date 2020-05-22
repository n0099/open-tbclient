package com.baidu.tieba.aiapps.apps.f;
/* loaded from: classes7.dex */
public class c {
    private static volatile b eSR;

    public static synchronized b boB() {
        b bVar;
        synchronized (c.class) {
            if (eSR == null) {
                eSR = new b();
            }
            bVar = eSR;
        }
        return bVar;
    }
}
