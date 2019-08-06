package com.baidu.tieba.aiapps.apps.b;
/* loaded from: classes2.dex */
public class b {
    private static volatile a dbx;

    public static synchronized a aEC() {
        a aVar;
        synchronized (b.class) {
            if (dbx == null) {
                dbx = new a();
            }
            aVar = dbx;
        }
        return aVar;
    }
}
