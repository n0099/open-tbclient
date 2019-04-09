package com.baidu.tieba.aiapps.apps.e;
/* loaded from: classes2.dex */
public class b {
    private static volatile a cTb;

    public static synchronized a ayY() {
        a aVar;
        synchronized (b.class) {
            if (cTb == null) {
                cTb = new a();
            }
            aVar = cTb;
        }
        return aVar;
    }
}
