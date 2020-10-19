package com.baidu.tieba.aiapps.apps.j;
/* loaded from: classes20.dex */
public class b {
    private static volatile a fJk;

    public static synchronized a bHm() {
        a aVar;
        synchronized (b.class) {
            if (fJk == null) {
                fJk = new a();
            }
            aVar = fJk;
        }
        return aVar;
    }
}
