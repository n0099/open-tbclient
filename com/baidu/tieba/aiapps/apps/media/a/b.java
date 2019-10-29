package com.baidu.tieba.aiapps.apps.media.a;
/* loaded from: classes2.dex */
public class b {
    private static volatile a dqq;

    public static synchronized a aGW() {
        a aVar;
        synchronized (b.class) {
            if (dqq == null) {
                dqq = new a();
            }
            aVar = dqq;
        }
        return aVar;
    }
}
