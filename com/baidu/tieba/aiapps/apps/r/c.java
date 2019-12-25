package com.baidu.tieba.aiapps.apps.r;
/* loaded from: classes4.dex */
public class c {
    private static volatile b ecr;

    public static synchronized b aYI() {
        b bVar;
        synchronized (c.class) {
            if (ecr == null) {
                ecr = new b();
            }
            bVar = ecr;
        }
        return bVar;
    }
}
