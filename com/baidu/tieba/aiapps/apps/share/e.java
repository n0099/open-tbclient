package com.baidu.tieba.aiapps.apps.share;
/* loaded from: classes4.dex */
public class e {
    private static volatile d ebU;

    public static synchronized d aYy() {
        d dVar;
        synchronized (e.class) {
            if (ebU == null) {
                ebU = new d();
            }
            dVar = ebU;
        }
        return dVar;
    }
}
