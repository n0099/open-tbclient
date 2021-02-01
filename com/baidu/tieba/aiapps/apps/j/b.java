package com.baidu.tieba.aiapps.apps.j;
/* loaded from: classes7.dex */
public class b {
    private static volatile a gmE;

    public static synchronized a bNI() {
        a aVar;
        synchronized (b.class) {
            if (gmE == null) {
                gmE = new a();
            }
            aVar = gmE;
        }
        return aVar;
    }
}
