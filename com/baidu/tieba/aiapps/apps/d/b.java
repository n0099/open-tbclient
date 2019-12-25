package com.baidu.tieba.aiapps.apps.d;
/* loaded from: classes4.dex */
public class b {
    private static volatile a dZm;

    public static synchronized a aXd() {
        a aVar;
        synchronized (b.class) {
            if (dZm == null) {
                dZm = new a();
            }
            aVar = dZm;
        }
        return aVar;
    }
}
