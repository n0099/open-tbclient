package com.baidu.tieba.aiapps.apps.media.a;
/* loaded from: classes2.dex */
public class b {
    private static volatile a dfj;

    public static synchronized a aGf() {
        a aVar;
        synchronized (b.class) {
            if (dfj == null) {
                dfj = new a();
            }
            aVar = dfj;
        }
        return aVar;
    }
}
