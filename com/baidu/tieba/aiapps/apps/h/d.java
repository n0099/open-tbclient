package com.baidu.tieba.aiapps.apps.h;
/* loaded from: classes20.dex */
public class d {
    private static volatile c fIZ;

    public static synchronized c bHc() {
        c cVar;
        synchronized (d.class) {
            if (fIZ == null) {
                fIZ = new c();
            }
            cVar = fIZ;
        }
        return cVar;
    }
}
