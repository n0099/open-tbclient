package com.baidu.tieba.aiapps.apps.b;
/* loaded from: classes2.dex */
public class b {
    private static volatile a dmF;

    public static synchronized a aFs() {
        a aVar;
        synchronized (b.class) {
            if (dmF == null) {
                dmF = new a();
            }
            aVar = dmF;
        }
        return aVar;
    }
}
