package com.baidu.tieba.aiapps.apps.k;
/* loaded from: classes7.dex */
public class b {
    private static volatile a eTm;

    public static synchronized a boL() {
        a aVar;
        synchronized (b.class) {
            if (eTm == null) {
                eTm = new a();
            }
            aVar = eTm;
        }
        return aVar;
    }
}
