package com.baidu.tieba.aiapps.apps.media.a;
/* loaded from: classes4.dex */
public class b {
    private static volatile a dZF;

    public static synchronized a aXj() {
        a aVar;
        synchronized (b.class) {
            if (dZF == null) {
                dZF = new a();
            }
            aVar = dZF;
        }
        return aVar;
    }
}
