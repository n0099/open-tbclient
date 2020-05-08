package com.baidu.tieba.aiapps.apps.d;
/* loaded from: classes7.dex */
public class b {
    private static volatile a eDZ;

    public static synchronized a bhV() {
        a aVar;
        synchronized (b.class) {
            if (eDZ == null) {
                eDZ = new a();
            }
            aVar = eDZ;
        }
        return aVar;
    }
}
