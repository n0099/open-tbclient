package com.baidu.tieba.aiapps.apps.b;
/* loaded from: classes7.dex */
public class b {
    private static volatile a gmc;

    public static synchronized a bNf() {
        a aVar;
        synchronized (b.class) {
            if (gmc == null) {
                gmc = new a();
            }
            aVar = gmc;
        }
        return aVar;
    }
}
