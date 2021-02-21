package com.baidu.tieba.aiapps.apps.k;
/* loaded from: classes7.dex */
public class b {
    private static volatile a gmT;

    public static synchronized a bNR() {
        a aVar;
        synchronized (b.class) {
            if (gmT == null) {
                gmT = new a();
            }
            aVar = gmT;
        }
        return aVar;
    }
}
