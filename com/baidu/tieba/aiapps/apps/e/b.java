package com.baidu.tieba.aiapps.apps.e;
/* loaded from: classes4.dex */
public class b {
    private static volatile a dZp;

    public static synchronized a aXf() {
        a aVar;
        synchronized (b.class) {
            if (dZp == null) {
                dZp = new a();
            }
            aVar = dZp;
        }
        return aVar;
    }
}
