package com.baidu.tieba.aiapps.apps.i;
/* loaded from: classes2.dex */
public class b {
    private static volatile a dds;

    public static synchronized a aEJ() {
        a aVar;
        synchronized (b.class) {
            if (dds == null) {
                dds = new a();
            }
            aVar = dds;
        }
        return aVar;
    }
}
