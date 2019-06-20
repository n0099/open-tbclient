package com.baidu.tieba.aiapps.apps.abtest;
/* loaded from: classes2.dex */
public class b {
    private static volatile a cZx;

    public static synchronized a aDf() {
        a aVar;
        synchronized (b.class) {
            if (cZx == null) {
                cZx = new a();
            }
            aVar = cZx;
        }
        return aVar;
    }
}
