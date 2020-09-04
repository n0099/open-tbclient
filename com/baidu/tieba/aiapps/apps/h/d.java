package com.baidu.tieba.aiapps.apps.h;
/* loaded from: classes14.dex */
public class d {
    private static volatile c ftG;

    public static synchronized c bDe() {
        c cVar;
        synchronized (d.class) {
            if (ftG == null) {
                ftG = new c();
            }
            cVar = ftG;
        }
        return cVar;
    }
}
