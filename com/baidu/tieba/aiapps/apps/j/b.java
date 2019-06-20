package com.baidu.tieba.aiapps.apps.j;
/* loaded from: classes2.dex */
public class b {
    private static volatile a ddw;

    public static synchronized a aEK() {
        a aVar;
        synchronized (b.class) {
            if (ddw == null) {
                ddw = new a();
            }
            aVar = ddw;
        }
        return aVar;
    }
}
