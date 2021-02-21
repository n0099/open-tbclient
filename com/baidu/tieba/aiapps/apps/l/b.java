package com.baidu.tieba.aiapps.apps.l;
/* loaded from: classes7.dex */
public class b {
    private static volatile a gmU;

    public static synchronized a bNS() {
        a aVar;
        synchronized (b.class) {
            if (gmU == null) {
                gmU = new a();
            }
            aVar = gmU;
        }
        return aVar;
    }
}
