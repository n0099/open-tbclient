package com.baidu.tieba.ala.alaar.sticker.a;

import android.util.ArrayMap;
import com.baidu.tieba.ala.alaar.sticker.model.e;
import java.io.File;
/* loaded from: classes4.dex */
public class f<T extends com.baidu.tieba.ala.alaar.sticker.model.e> {
    private static f gkJ;
    private ArrayMap<String, T> gkE = new ArrayMap<>();
    private File mFolder;

    public static f<com.baidu.tieba.ala.alaar.sticker.model.c> bQK() {
        if (gkJ == null) {
            bQL();
        }
        return gkJ;
    }

    private static synchronized void bQL() {
        synchronized (f.class) {
            if (gkJ == null) {
                gkJ = new f(a.bQB().bQD());
            }
        }
    }

    private f(File file) {
        this.mFolder = file;
    }

    public T a(String str, T t) {
        return this.gkE.put(str, t);
    }

    public T Gw(String str) {
        return this.gkE.get(str);
    }
}
