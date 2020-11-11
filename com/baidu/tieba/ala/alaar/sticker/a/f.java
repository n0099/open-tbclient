package com.baidu.tieba.ala.alaar.sticker.a;

import android.util.ArrayMap;
import com.baidu.tieba.ala.alaar.sticker.model.e;
import java.io.File;
/* loaded from: classes4.dex */
public class f<T extends com.baidu.tieba.ala.alaar.sticker.model.e> {
    private static f gcP;
    private ArrayMap<String, T> gcK = new ArrayMap<>();
    private File mFolder;

    public static f<com.baidu.tieba.ala.alaar.sticker.model.c> bNF() {
        if (gcP == null) {
            bNG();
        }
        return gcP;
    }

    private static synchronized void bNG() {
        synchronized (f.class) {
            if (gcP == null) {
                gcP = new f(a.bNw().bNy());
            }
        }
    }

    private f(File file) {
        this.mFolder = file;
    }

    public T a(String str, T t) {
        return this.gcK.put(str, t);
    }

    public T Gg(String str) {
        return this.gcK.get(str);
    }
}
