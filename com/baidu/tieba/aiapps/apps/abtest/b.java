package com.baidu.tieba.aiapps.apps.abtest;
/* loaded from: classes2.dex */
public class b {
    private static volatile a cZw;

    public static synchronized a aDf() {
        a aVar;
        synchronized (b.class) {
            if (cZw == null) {
                cZw = new a();
            }
            aVar = cZw;
        }
        return aVar;
    }
}
