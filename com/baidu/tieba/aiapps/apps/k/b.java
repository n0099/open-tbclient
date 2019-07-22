package com.baidu.tieba.aiapps.apps.k;
/* loaded from: classes2.dex */
public class b {
    private static volatile a dha;

    public static synchronized a aGW() {
        a aVar;
        synchronized (b.class) {
            if (dha == null) {
                dha = new a();
            }
            aVar = dha;
        }
        return aVar;
    }
}
