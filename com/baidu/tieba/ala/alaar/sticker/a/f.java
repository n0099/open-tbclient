package com.baidu.tieba.ala.alaar.sticker.a;

import android.util.ArrayMap;
import com.baidu.tieba.ala.alaar.sticker.model.e;
import java.io.File;
/* loaded from: classes10.dex */
public class f<T extends com.baidu.tieba.ala.alaar.sticker.model.e> {
    private static f gvi;
    private ArrayMap<String, T> gvd = new ArrayMap<>();
    private File mFolder;

    public static f<com.baidu.tieba.ala.alaar.sticker.model.c> bQj() {
        if (gvi == null) {
            bQk();
        }
        return gvi;
    }

    private static synchronized void bQk() {
        synchronized (f.class) {
            if (gvi == null) {
                gvi = new f(a.bQa().bQc());
            }
        }
    }

    private f(File file) {
        this.mFolder = file;
    }

    public T a(String str, T t) {
        return this.gvd.put(str, t);
    }

    public T FR(String str) {
        return this.gvd.get(str);
    }
}
