package com.baidu.tieba.aiapps.apps.g;
/* loaded from: classes2.dex */
public class b {
    private static volatile a dpo;

    public static synchronized a aGR() {
        a aVar;
        synchronized (b.class) {
            if (dpo == null) {
                dpo = new a();
            }
            aVar = dpo;
        }
        return aVar;
    }
}
