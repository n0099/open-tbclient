package com.baidu.tieba.aiapps.apps.h;
/* loaded from: classes2.dex */
public class b {
    private static volatile a dgN;

    public static synchronized a aGH() {
        a aVar;
        synchronized (b.class) {
            if (dgN == null) {
                dgN = new a();
            }
            aVar = dgN;
        }
        return aVar;
    }
}
