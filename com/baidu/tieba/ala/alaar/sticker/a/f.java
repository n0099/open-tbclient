package com.baidu.tieba.ala.alaar.sticker.a;

import android.util.ArrayMap;
import com.baidu.tieba.ala.alaar.sticker.model.e;
import java.io.File;
/* loaded from: classes4.dex */
public class f<T extends com.baidu.tieba.ala.alaar.sticker.model.e> {
    private static f gcw;
    private ArrayMap<String, T> gcr = new ArrayMap<>();
    private File mFolder;

    public static f<com.baidu.tieba.ala.alaar.sticker.model.c> bMY() {
        if (gcw == null) {
            bMZ();
        }
        return gcw;
    }

    private static synchronized void bMZ() {
        synchronized (f.class) {
            if (gcw == null) {
                gcw = new f(a.bMP().bMR());
            }
        }
    }

    private f(File file) {
        this.mFolder = file;
    }

    public T a(String str, T t) {
        return this.gcr.put(str, t);
    }

    public T FH(String str) {
        return this.gcr.get(str);
    }
}
