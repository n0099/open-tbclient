package com.baidu.tieba.aiapps.apps.j;
/* loaded from: classes7.dex */
public class b {
    private static volatile a goE;

    public static synchronized a bQY() {
        a aVar;
        synchronized (b.class) {
            if (goE == null) {
                goE = new a();
            }
            aVar = goE;
        }
        return aVar;
    }
}
