package com.baidu.tieba.aiapps.apps.f;
/* loaded from: classes20.dex */
public class c {
    private static volatile b geT;

    public static synchronized b bOu() {
        b bVar;
        synchronized (c.class) {
            if (geT == null) {
                geT = new b();
            }
            bVar = geT;
        }
        return bVar;
    }
}
