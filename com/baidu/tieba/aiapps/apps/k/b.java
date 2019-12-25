package com.baidu.tieba.aiapps.apps.k;
/* loaded from: classes4.dex */
public class b {
    private static volatile a ebE;

    public static synchronized a aYs() {
        a aVar;
        synchronized (b.class) {
            if (ebE == null) {
                ebE = new a();
            }
            aVar = ebE;
        }
        return aVar;
    }
}
