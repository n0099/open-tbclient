package com.baidu.tieba.aiapps.apps.e;
/* loaded from: classes2.dex */
public class b {
    private static volatile a deV;

    public static synchronized a aGk() {
        a aVar;
        synchronized (b.class) {
            if (deV == null) {
                deV = new a();
            }
            aVar = deV;
        }
        return aVar;
    }
}
