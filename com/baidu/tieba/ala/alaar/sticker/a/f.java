package com.baidu.tieba.ala.alaar.sticker.a;

import android.util.ArrayMap;
import com.baidu.tieba.ala.alaar.sticker.model.e;
import java.io.File;
/* loaded from: classes11.dex */
public class f<T extends com.baidu.tieba.ala.alaar.sticker.model.e> {
    private static f gtl;
    private ArrayMap<String, T> gtg = new ArrayMap<>();
    private File mFolder;

    public static f<com.baidu.tieba.ala.alaar.sticker.model.c> bPW() {
        if (gtl == null) {
            bPX();
        }
        return gtl;
    }

    private static synchronized void bPX() {
        synchronized (f.class) {
            if (gtl == null) {
                gtl = new f(a.bPN().bPP());
            }
        }
    }

    private f(File file) {
        this.mFolder = file;
    }

    public T a(String str, T t) {
        return this.gtg.put(str, t);
    }

    public T FH(String str) {
        return this.gtg.get(str);
    }
}
