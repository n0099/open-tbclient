package com.baidu.tieba.aiapps.apps.b;
/* loaded from: classes14.dex */
public class b {
    private static volatile a fsU;

    public static synchronized a bCD() {
        a aVar;
        synchronized (b.class) {
            if (fsU == null) {
                fsU = new a();
            }
            aVar = fsU;
        }
        return aVar;
    }
}
