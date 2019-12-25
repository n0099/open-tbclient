package com.baidu.tieba.aiapps.apps.g;
/* loaded from: classes4.dex */
public class b {
    private static volatile a ebv;

    public static synchronized a aXW() {
        a aVar;
        synchronized (b.class) {
            if (ebv == null) {
                ebv = new a();
            }
            aVar = ebv;
        }
        return aVar;
    }
}
