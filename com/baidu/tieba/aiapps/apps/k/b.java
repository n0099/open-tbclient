package com.baidu.tieba.aiapps.apps.k;
/* loaded from: classes7.dex */
public class b {
    private static volatile a goF;

    public static synchronized a bRa() {
        a aVar;
        synchronized (b.class) {
            if (goF == null) {
                goF = new a();
            }
            aVar = goF;
        }
        return aVar;
    }
}
