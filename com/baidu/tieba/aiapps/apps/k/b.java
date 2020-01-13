package com.baidu.tieba.aiapps.apps.k;
/* loaded from: classes5.dex */
public class b {
    private static volatile a ebN;

    public static synchronized a aYM() {
        a aVar;
        synchronized (b.class) {
            if (ebN == null) {
                ebN = new a();
            }
            aVar = ebN;
        }
        return aVar;
    }
}
