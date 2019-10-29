package com.baidu.tieba.aiapps.apps.r;
/* loaded from: classes2.dex */
public class b {
    private static volatile a dtk;

    public static synchronized a aIC() {
        a aVar;
        synchronized (b.class) {
            if (dtk == null) {
                dtk = new a();
            }
            aVar = dtk;
        }
        return aVar;
    }
}
