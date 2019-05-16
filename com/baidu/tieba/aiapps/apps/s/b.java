package com.baidu.tieba.aiapps.apps.s;
/* loaded from: classes2.dex */
public class b {
    private static volatile a dgp;

    public static synchronized a aGn() {
        a aVar;
        synchronized (b.class) {
            if (dgp == null) {
                dgp = new a();
            }
            aVar = dgp;
        }
        return aVar;
    }
}
