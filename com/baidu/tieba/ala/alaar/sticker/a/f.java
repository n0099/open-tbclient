package com.baidu.tieba.ala.alaar.sticker.a;

import android.util.ArrayMap;
import com.baidu.tieba.ala.alaar.sticker.model.e;
import java.io.File;
/* loaded from: classes11.dex */
public class f<T extends com.baidu.tieba.ala.alaar.sticker.model.e> {
    private static f gtz;
    private ArrayMap<String, T> gtu = new ArrayMap<>();
    private File mFolder;

    public static f<com.baidu.tieba.ala.alaar.sticker.model.c> bQd() {
        if (gtz == null) {
            bQe();
        }
        return gtz;
    }

    private static synchronized void bQe() {
        synchronized (f.class) {
            if (gtz == null) {
                gtz = new f(a.bPU().bPW());
            }
        }
    }

    private f(File file) {
        this.mFolder = file;
    }

    public T a(String str, T t) {
        return this.gtu.put(str, t);
    }

    public T FI(String str) {
        return this.gtu.get(str);
    }
}
