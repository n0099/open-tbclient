package com.baidu.tieba.aiapps.apps.l;
/* loaded from: classes20.dex */
public class b {
    private static volatile a fJm;

    public static synchronized a bHp() {
        a aVar;
        synchronized (b.class) {
            if (fJm == null) {
                fJm = new a();
            }
            aVar = fJm;
        }
        return aVar;
    }
}
