package com.baidu.tieba.aiapps.apps.c;
/* loaded from: classes2.dex */
public class b {
    private static volatile a dbm;

    public static synchronized a aDM() {
        a aVar;
        synchronized (b.class) {
            if (dbm == null) {
                dbm = new a();
            }
            aVar = dbm;
        }
        return aVar;
    }
}
