package com.baidu.tieba.aiapps.apps.abtest;
/* loaded from: classes2.dex */
public class b {
    private static volatile a dbc;

    public static synchronized a aEx() {
        a aVar;
        synchronized (b.class) {
            if (dbc == null) {
                dbc = new a();
            }
            aVar = dbc;
        }
        return aVar;
    }
}
