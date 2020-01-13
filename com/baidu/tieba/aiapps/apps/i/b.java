package com.baidu.tieba.aiapps.apps.i;
/* loaded from: classes5.dex */
public class b {
    private static volatile a ebF;

    public static synchronized a aYs() {
        a aVar;
        synchronized (b.class) {
            if (ebF == null) {
                ebF = new a();
            }
            aVar = ebF;
        }
        return aVar;
    }
}
