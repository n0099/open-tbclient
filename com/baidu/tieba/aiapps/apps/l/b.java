package com.baidu.tieba.aiapps.apps.l;
/* loaded from: classes2.dex */
public class b {
    private static volatile a dfv;

    public static synchronized a aFx() {
        a aVar;
        synchronized (b.class) {
            if (dfv == null) {
                dfv = new a();
            }
            aVar = dfv;
        }
        return aVar;
    }
}
