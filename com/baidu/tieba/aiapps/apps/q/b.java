package com.baidu.tieba.aiapps.apps.q;
/* loaded from: classes2.dex */
public class b {
    private static volatile a cWR;

    public static synchronized a aAc() {
        a aVar;
        synchronized (b.class) {
            if (cWR == null) {
                cWR = new a();
            }
            aVar = cWR;
        }
        return aVar;
    }
}
