package com.baidu.tieba.aiapps.apps.n;
/* loaded from: classes2.dex */
public class b {
    private static volatile a dfP;

    public static synchronized a aFZ() {
        a aVar;
        synchronized (b.class) {
            if (dfP == null) {
                dfP = new a();
            }
            aVar = dfP;
        }
        return aVar;
    }
}
