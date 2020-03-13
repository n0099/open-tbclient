package com.baidu.tieba.aiapps.apps.media.a;
/* loaded from: classes7.dex */
public class b {
    private static volatile a eef;

    public static synchronized a aZV() {
        a aVar;
        synchronized (b.class) {
            if (eef == null) {
                eef = new a();
            }
            aVar = eef;
        }
        return aVar;
    }
}
