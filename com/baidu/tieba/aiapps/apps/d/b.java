package com.baidu.tieba.aiapps.apps.d;
/* loaded from: classes7.dex */
public class b {
    private static volatile a eSH;

    public static synchronized a boh() {
        a aVar;
        synchronized (b.class) {
            if (eSH == null) {
                eSH = new a();
            }
            aVar = eSH;
        }
        return aVar;
    }
}
