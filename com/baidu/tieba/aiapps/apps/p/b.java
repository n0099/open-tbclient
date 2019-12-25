package com.baidu.tieba.aiapps.apps.p;
/* loaded from: classes4.dex */
public class b {
    private static volatile a ebX;

    public static synchronized a aYD() {
        a aVar;
        synchronized (b.class) {
            if (ebX == null) {
                ebX = new a();
            }
            aVar = ebX;
        }
        return aVar;
    }
}
