package com.baidu.tieba.aiapps.apps.l;
/* loaded from: classes2.dex */
public class b {
    private static volatile a dfw;

    public static synchronized a aFA() {
        a aVar;
        synchronized (b.class) {
            if (dfw == null) {
                dfw = new a();
            }
            aVar = dfw;
        }
        return aVar;
    }
}
