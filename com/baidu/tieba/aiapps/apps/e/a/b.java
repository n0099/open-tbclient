package com.baidu.tieba.aiapps.apps.e.a;
/* loaded from: classes6.dex */
public class b {
    private static volatile a gjy;

    public static synchronized a bMD() {
        a aVar;
        synchronized (b.class) {
            if (gjy == null) {
                gjy = new a();
            }
            aVar = gjy;
        }
        return aVar;
    }
}
