package com.baidu.tieba.aiapps.apps.i;
/* loaded from: classes2.dex */
public class b {
    private static volatile a ddr;

    public static synchronized a aEG() {
        a aVar;
        synchronized (b.class) {
            if (ddr == null) {
                ddr = new a();
            }
            aVar = ddr;
        }
        return aVar;
    }
}
