package com.baidu.tieba.aiapps.apps.g;
/* loaded from: classes7.dex */
public class b {
    private static volatile a eGg;

    public static synchronized a biN() {
        a aVar;
        synchronized (b.class) {
            if (eGg == null) {
                eGg = new a();
            }
            aVar = eGg;
        }
        return aVar;
    }
}
