package com.baidu.tieba.aiapps.apps.media.b;
/* loaded from: classes2.dex */
public class e {
    private static volatile d dfs;

    public static synchronized d aGh() {
        d dVar;
        synchronized (e.class) {
            if (dfs == null) {
                dfs = new d();
            }
            dVar = dfs;
        }
        return dVar;
    }
}
