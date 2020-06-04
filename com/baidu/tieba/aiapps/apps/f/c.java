package com.baidu.tieba.aiapps.apps.f;
/* loaded from: classes7.dex */
public class c {
    private static volatile b eTc;

    public static synchronized b boD() {
        b bVar;
        synchronized (c.class) {
            if (eTc == null) {
                eTc = new b();
            }
            bVar = eTc;
        }
        return bVar;
    }
}
