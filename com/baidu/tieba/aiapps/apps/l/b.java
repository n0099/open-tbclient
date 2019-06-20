package com.baidu.tieba.aiapps.apps.l;
/* loaded from: classes2.dex */
public class b {
    private static volatile a dfx;

    public static synchronized a aFA() {
        a aVar;
        synchronized (b.class) {
            if (dfx == null) {
                dfx = new a();
            }
            aVar = dfx;
        }
        return aVar;
    }
}
