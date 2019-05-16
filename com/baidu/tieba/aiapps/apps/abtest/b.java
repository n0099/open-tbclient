package com.baidu.tieba.aiapps.apps.abtest;
/* loaded from: classes2.dex */
public class b {
    private static volatile a cZv;

    public static synchronized a aDc() {
        a aVar;
        synchronized (b.class) {
            if (cZv == null) {
                cZv = new a();
            }
            aVar = cZv;
        }
        return aVar;
    }
}
