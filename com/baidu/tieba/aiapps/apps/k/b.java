package com.baidu.tieba.aiapps.apps.k;
/* loaded from: classes6.dex */
public class b {
    private static volatile a gjY;

    public static synchronized a bNj() {
        a aVar;
        synchronized (b.class) {
            if (gjY == null) {
                gjY = new a();
            }
            aVar = gjY;
        }
        return aVar;
    }
}
