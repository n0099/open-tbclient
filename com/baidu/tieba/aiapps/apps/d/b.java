package com.baidu.tieba.aiapps.apps.d;
/* loaded from: classes7.dex */
public class b {
    private static volatile a eSS;

    public static synchronized a boj() {
        a aVar;
        synchronized (b.class) {
            if (eSS == null) {
                eSS = new a();
            }
            aVar = eSS;
        }
        return aVar;
    }
}
