package com.baidu.tieba.aiapps.apps.j;
/* loaded from: classes2.dex */
public class b {
    private static volatile a ddv;

    public static synchronized a aEK() {
        a aVar;
        synchronized (b.class) {
            if (ddv == null) {
                ddv = new a();
            }
            aVar = ddv;
        }
        return aVar;
    }
}
