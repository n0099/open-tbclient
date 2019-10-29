package com.baidu.tieba.aiapps.apps.g;
/* loaded from: classes2.dex */
public class b {
    private static volatile a dqf;

    public static synchronized a aGT() {
        a aVar;
        synchronized (b.class) {
            if (dqf == null) {
                dqf = new a();
            }
            aVar = dqf;
        }
        return aVar;
    }
}
