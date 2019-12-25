package com.baidu.tieba.aiapps.apps.c;
/* loaded from: classes4.dex */
public class b {
    private static volatile a dZl;

    public static synchronized a aXc() {
        a aVar;
        synchronized (b.class) {
            if (dZl == null) {
                dZl = new a();
            }
            aVar = dZl;
        }
        return aVar;
    }
}
