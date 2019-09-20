package com.baidu.tieba.aiapps.apps.i;
/* loaded from: classes2.dex */
public class b {
    private static volatile a dgP;

    public static synchronized a aGI() {
        a aVar;
        synchronized (b.class) {
            if (dgP == null) {
                dgP = new a();
            }
            aVar = dgP;
        }
        return aVar;
    }
}
