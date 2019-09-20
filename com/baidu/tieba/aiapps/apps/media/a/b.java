package com.baidu.tieba.aiapps.apps.media.a;
/* loaded from: classes2.dex */
public class b {
    private static volatile a dgU;

    public static synchronized a aGJ() {
        a aVar;
        synchronized (b.class) {
            if (dgU == null) {
                dgU = new a();
            }
            aVar = dgU;
        }
        return aVar;
    }
}
