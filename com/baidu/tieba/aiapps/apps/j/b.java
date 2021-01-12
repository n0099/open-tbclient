package com.baidu.tieba.aiapps.apps.j;
/* loaded from: classes6.dex */
public class b {
    private static volatile a gjX;

    public static synchronized a bNh() {
        a aVar;
        synchronized (b.class) {
            if (gjX == null) {
                gjX = new a();
            }
            aVar = gjX;
        }
        return aVar;
    }
}
