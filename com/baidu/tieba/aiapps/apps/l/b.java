package com.baidu.tieba.aiapps.apps.l;
/* loaded from: classes7.dex */
public class b {
    private static volatile a gmG;

    public static synchronized a bNL() {
        a aVar;
        synchronized (b.class) {
            if (gmG == null) {
                gmG = new a();
            }
            aVar = gmG;
        }
        return aVar;
    }
}
