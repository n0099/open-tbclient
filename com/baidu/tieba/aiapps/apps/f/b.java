package com.baidu.tieba.aiapps.apps.f;
/* loaded from: classes7.dex */
public class b {
    private static volatile a eEh;

    public static synchronized a bic() {
        a aVar;
        synchronized (b.class) {
            if (eEh == null) {
                eEh = new a();
            }
            aVar = eEh;
        }
        return aVar;
    }
}
