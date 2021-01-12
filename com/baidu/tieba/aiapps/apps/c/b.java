package com.baidu.tieba.aiapps.apps.c;
/* loaded from: classes6.dex */
public class b {
    private static volatile a gjk;

    public static synchronized a bMz() {
        a aVar;
        synchronized (b.class) {
            if (gjk == null) {
                gjk = new a();
            }
            aVar = gjk;
        }
        return aVar;
    }
}
