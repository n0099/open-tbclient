package com.baidu.tieba.ala.alaar.sticker.a;

import android.text.TextUtils;
import android.util.ArrayMap;
import com.baidu.tieba.ala.alaar.sticker.model.e;
import java.io.File;
/* loaded from: classes10.dex */
public class c<T extends com.baidu.tieba.ala.alaar.sticker.model.e> {
    private static c gqu;
    private static c gqv;
    private ArrayMap<String, T> gqw = new ArrayMap<>();
    private File mFolder;

    public static c<com.baidu.tieba.ala.alaar.sticker.model.b> bPo() {
        if (gqu == null) {
            gqu = bPp();
        }
        return gqu;
    }

    private static synchronized c<com.baidu.tieba.ala.alaar.sticker.model.b> bPp() {
        c<com.baidu.tieba.ala.alaar.sticker.model.b> cVar;
        synchronized (c.class) {
            if (gqu == null) {
                gqu = new c(a.bPj().bPl());
            }
            cVar = gqu;
        }
        return cVar;
    }

    public static c<com.baidu.tieba.ala.alaar.sticker.model.d> bPn() {
        if (gqv == null) {
            gqv = bPq();
        }
        return gqv;
    }

    private static synchronized c<com.baidu.tieba.ala.alaar.sticker.model.d> bPq() {
        c<com.baidu.tieba.ala.alaar.sticker.model.d> cVar;
        synchronized (c.class) {
            if (gqv == null) {
                gqv = new c(a.bPj().bPm());
            }
            cVar = gqv;
        }
        return cVar;
    }

    private c(File file) {
        this.mFolder = file;
    }

    public T Fb(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.gqw.get(str);
    }

    public T a(String str, T t) {
        return this.gqw.put(str, t);
    }

    public void a(String str, com.baidu.tieba.ala.alaar.sticker.download.a.a aVar) {
        T t;
        if (!TextUtils.isEmpty(str) && (t = this.gqw.get(str)) != null) {
            t.b(aVar);
        }
    }
}
