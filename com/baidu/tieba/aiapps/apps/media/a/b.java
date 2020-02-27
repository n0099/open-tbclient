package com.baidu.tieba.aiapps.apps.media.a;
/* loaded from: classes7.dex */
public class b {
    private static volatile a edR;

    public static synchronized a aZS() {
        a aVar;
        synchronized (b.class) {
            if (edR == null) {
                edR = new a();
            }
            aVar = edR;
        }
        return aVar;
    }
}
