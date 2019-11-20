package com.baidu.tieba.aiapps.apps.r;
/* loaded from: classes2.dex */
public class b {
    private static volatile a dss;

    public static synchronized a aIA() {
        a aVar;
        synchronized (b.class) {
            if (dss == null) {
                dss = new a();
            }
            aVar = dss;
        }
        return aVar;
    }
}
