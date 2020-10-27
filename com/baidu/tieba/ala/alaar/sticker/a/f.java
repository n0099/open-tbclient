package com.baidu.tieba.ala.alaar.sticker.a;

import android.util.ArrayMap;
import com.baidu.tieba.ala.alaar.sticker.model.e;
import java.io.File;
/* loaded from: classes4.dex */
public class f<T extends com.baidu.tieba.ala.alaar.sticker.model.e> {
    private static f fWY;
    private ArrayMap<String, T> fWT = new ArrayMap<>();
    private File mFolder;

    public static f<com.baidu.tieba.ala.alaar.sticker.model.c> bLg() {
        if (fWY == null) {
            bLh();
        }
        return fWY;
    }

    private static synchronized void bLh() {
        synchronized (f.class) {
            if (fWY == null) {
                fWY = new f(a.bKX().bKZ());
            }
        }
    }

    private f(File file) {
        this.mFolder = file;
    }

    public T a(String str, T t) {
        return this.fWT.put(str, t);
    }

    public T FS(String str) {
        return this.fWT.get(str);
    }
}
