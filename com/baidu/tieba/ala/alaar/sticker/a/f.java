package com.baidu.tieba.ala.alaar.sticker.a;

import android.util.ArrayMap;
import com.baidu.tieba.ala.alaar.sticker.model.e;
import java.io.File;
/* loaded from: classes10.dex */
public class f<T extends com.baidu.tieba.ala.alaar.sticker.model.e> {
    private static f gqB;
    private ArrayMap<String, T> gqw = new ArrayMap<>();
    private File mFolder;

    public static f<com.baidu.tieba.ala.alaar.sticker.model.c> bPs() {
        if (gqB == null) {
            bPt();
        }
        return gqB;
    }

    private static synchronized void bPt() {
        synchronized (f.class) {
            if (gqB == null) {
                gqB = new f(a.bPj().bPl());
            }
        }
    }

    private f(File file) {
        this.mFolder = file;
    }

    public T a(String str, T t) {
        return this.gqw.put(str, t);
    }

    public T Fj(String str) {
        return this.gqw.get(str);
    }
}
