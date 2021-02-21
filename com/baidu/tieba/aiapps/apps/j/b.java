package com.baidu.tieba.aiapps.apps.j;
/* loaded from: classes7.dex */
public class b {
    private static volatile a gmS;

    public static synchronized a bNP() {
        a aVar;
        synchronized (b.class) {
            if (gmS == null) {
                gmS = new a();
            }
            aVar = gmS;
        }
        return aVar;
    }
}
