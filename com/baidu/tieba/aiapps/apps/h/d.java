package com.baidu.tieba.aiapps.apps.h;
/* loaded from: classes20.dex */
public class d {
    private static volatile c gfc;

    public static synchronized c bOv() {
        c cVar;
        synchronized (d.class) {
            if (gfc == null) {
                gfc = new c();
            }
            cVar = gfc;
        }
        return cVar;
    }
}
