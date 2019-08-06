package com.baidu.tieba.aiapps.apps.i;
/* loaded from: classes2.dex */
public class b {
    private static volatile a dfe;

    public static synchronized a aGe() {
        a aVar;
        synchronized (b.class) {
            if (dfe == null) {
                dfe = new a();
            }
            aVar = dfe;
        }
        return aVar;
    }
}
