package com.baidu.tieba.ala.alaar.sticker.a;

import android.util.ArrayMap;
import com.baidu.tieba.ala.alaar.sticker.model.e;
import java.io.File;
/* loaded from: classes11.dex */
public class f<T extends com.baidu.tieba.ala.alaar.sticker.model.e> {
    private static f gvi;
    private ArrayMap<String, T> gvd = new ArrayMap<>();
    private File mFolder;

    public static f<com.baidu.tieba.ala.alaar.sticker.model.c> bTk() {
        if (gvi == null) {
            bTl();
        }
        return gvi;
    }

    private static synchronized void bTl() {
        synchronized (f.class) {
            if (gvi == null) {
                gvi = new f(a.bTb().bTd());
            }
        }
    }

    private f(File file) {
        this.mFolder = file;
    }

    public T a(String str, T t) {
        return this.gvd.put(str, t);
    }

    public T Gu(String str) {
        return this.gvd.get(str);
    }
}
