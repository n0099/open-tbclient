package com.baidu.tieba.aiapps.apps.o;
/* loaded from: classes4.dex */
public class b {
    private static volatile a ebW;

    public static synchronized a aYC() {
        a aVar;
        synchronized (b.class) {
            if (ebW == null) {
                ebW = new a();
            }
            aVar = ebW;
        }
        return aVar;
    }
}
