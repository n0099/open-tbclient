package com.baidu.tieba.aiapps.apps.abtest;
/* loaded from: classes2.dex */
public class b {
    private static volatile a cQY;

    public static synchronized a axY() {
        a aVar;
        synchronized (b.class) {
            if (cQY == null) {
                cQY = new a();
            }
            aVar = cQY;
        }
        return aVar;
    }
}
