package com.baidu.tieba.aiapps.apps.h;
/* loaded from: classes7.dex */
public class d {
    private static volatile c got;

    public static synchronized c bQO() {
        c cVar;
        synchronized (d.class) {
            if (got == null) {
                got = new c();
            }
            cVar = got;
        }
        return cVar;
    }
}
