package com.baidu.tieba.aiapps.apps.s;
/* loaded from: classes2.dex */
public class b {
    private static volatile a dgq;

    public static synchronized a aGq() {
        a aVar;
        synchronized (b.class) {
            if (dgq == null) {
                dgq = new a();
            }
            aVar = dgq;
        }
        return aVar;
    }
}
