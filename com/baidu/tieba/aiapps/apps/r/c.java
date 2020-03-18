package com.baidu.tieba.aiapps.apps.r;
/* loaded from: classes7.dex */
public class c {
    private static volatile b ehh;

    public static synchronized b bby() {
        b bVar;
        synchronized (c.class) {
            if (ehh == null) {
                ehh = new b();
            }
            bVar = ehh;
        }
        return bVar;
    }
}
