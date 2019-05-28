package com.baidu.tieba.aiapps.apps.p;
/* loaded from: classes2.dex */
public class b {
    private static volatile a dfT;

    public static synchronized a aGb() {
        a aVar;
        synchronized (b.class) {
            if (dfT == null) {
                dfT = new a();
            }
            aVar = dfT;
        }
        return aVar;
    }
}
