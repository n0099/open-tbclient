package com.baidu.tieba.aiapps.apps.i;
/* loaded from: classes7.dex */
public class b {
    private static volatile a egm;

    public static synchronized a baO() {
        a aVar;
        synchronized (b.class) {
            if (egm == null) {
                egm = new a();
            }
            aVar = egm;
        }
        return aVar;
    }
}
