package com.baidu.tieba.ala.alaar.sticker.a;

import android.util.ArrayMap;
import com.baidu.tieba.ala.alaar.sticker.model.e;
import java.io.File;
/* loaded from: classes4.dex */
public class f<T extends com.baidu.tieba.ala.alaar.sticker.model.e> {
    private static f gkH;
    private ArrayMap<String, T> gkC = new ArrayMap<>();
    private File mFolder;

    public static f<com.baidu.tieba.ala.alaar.sticker.model.c> bQJ() {
        if (gkH == null) {
            bQK();
        }
        return gkH;
    }

    private static synchronized void bQK() {
        synchronized (f.class) {
            if (gkH == null) {
                gkH = new f(a.bQA().bQC());
            }
        }
    }

    private f(File file) {
        this.mFolder = file;
    }

    public T a(String str, T t) {
        return this.gkC.put(str, t);
    }

    public T Gw(String str) {
        return this.gkC.get(str);
    }
}
