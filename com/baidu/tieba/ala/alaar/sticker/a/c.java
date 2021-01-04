package com.baidu.tieba.ala.alaar.sticker.a;

import android.text.TextUtils;
import android.util.ArrayMap;
import com.baidu.tieba.ala.alaar.sticker.model.e;
import java.io.File;
/* loaded from: classes11.dex */
public class c<T extends com.baidu.tieba.ala.alaar.sticker.model.e> {
    private static c gvb;
    private static c gvc;
    private ArrayMap<String, T> gvd = new ArrayMap<>();
    private File mFolder;

    public static c<com.baidu.tieba.ala.alaar.sticker.model.b> bTf() {
        if (gvb == null) {
            gvb = bTg();
        }
        return gvb;
    }

    private static synchronized c<com.baidu.tieba.ala.alaar.sticker.model.b> bTg() {
        c<com.baidu.tieba.ala.alaar.sticker.model.b> cVar;
        synchronized (c.class) {
            if (gvb == null) {
                gvb = new c(a.bTa().bTc());
            }
            cVar = gvb;
        }
        return cVar;
    }

    public static c<com.baidu.tieba.ala.alaar.sticker.model.d> bTe() {
        if (gvc == null) {
            gvc = bTh();
        }
        return gvc;
    }

    private static synchronized c<com.baidu.tieba.ala.alaar.sticker.model.d> bTh() {
        c<com.baidu.tieba.ala.alaar.sticker.model.d> cVar;
        synchronized (c.class) {
            if (gvc == null) {
                gvc = new c(a.bTa().bTd());
            }
            cVar = gvc;
        }
        return cVar;
    }

    private c(File file) {
        this.mFolder = file;
    }

    public T Gn(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.gvd.get(str);
    }

    public T a(String str, T t) {
        return this.gvd.put(str, t);
    }

    public void a(String str, com.baidu.tieba.ala.alaar.sticker.download.a.a aVar) {
        T t;
        if (!TextUtils.isEmpty(str) && (t = this.gvd.get(str)) != null) {
            t.b(aVar);
        }
    }
}
