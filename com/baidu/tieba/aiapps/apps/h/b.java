package com.baidu.tieba.aiapps.apps.h;
/* loaded from: classes2.dex */
public class b {
    private static volatile a dqj;

    public static synchronized a aGU() {
        a aVar;
        synchronized (b.class) {
            if (dqj == null) {
                dqj = new a();
            }
            aVar = dqj;
        }
        return aVar;
    }
}
