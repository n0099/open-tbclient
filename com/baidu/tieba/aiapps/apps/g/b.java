package com.baidu.tieba.aiapps.apps.g;
/* loaded from: classes5.dex */
public class b {
    private static volatile a ebE;

    public static synchronized a aYq() {
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
