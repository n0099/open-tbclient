package com.baidu.tieba.aiapps.apps.c;
/* loaded from: classes7.dex */
public class b {
    private static volatile a gmf;

    public static synchronized a bNh() {
        a aVar;
        synchronized (b.class) {
            if (gmf == null) {
                gmf = new a();
            }
            aVar = gmf;
        }
        return aVar;
    }
}
