package com.baidu.tieba.aiapps.apps.g;
/* loaded from: classes2.dex */
public class b {
    private static volatile a dgJ;

    public static synchronized a aGG() {
        a aVar;
        synchronized (b.class) {
            if (dgJ == null) {
                dgJ = new a();
            }
            aVar = dgJ;
        }
        return aVar;
    }
}
