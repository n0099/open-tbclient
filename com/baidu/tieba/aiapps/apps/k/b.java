package com.baidu.tieba.aiapps.apps.k;
/* loaded from: classes6.dex */
public class b {
    private static volatile a goC;

    public static synchronized a bNX() {
        a aVar;
        synchronized (b.class) {
            if (goC == null) {
                goC = new a();
            }
            aVar = goC;
        }
        return aVar;
    }
}
