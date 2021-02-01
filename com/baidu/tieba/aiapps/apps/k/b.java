package com.baidu.tieba.aiapps.apps.k;
/* loaded from: classes7.dex */
public class b {
    private static volatile a gmF;

    public static synchronized a bNK() {
        a aVar;
        synchronized (b.class) {
            if (gmF == null) {
                gmF = new a();
            }
            aVar = gmF;
        }
        return aVar;
    }
}
