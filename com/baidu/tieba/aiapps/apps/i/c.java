package com.baidu.tieba.aiapps.apps.i;
/* loaded from: classes14.dex */
public class c {
    private static volatile b fio;

    public static synchronized b bur() {
        b bVar;
        synchronized (c.class) {
            if (fio == null) {
                fio = new b();
            }
            bVar = fio;
        }
        return bVar;
    }
}
