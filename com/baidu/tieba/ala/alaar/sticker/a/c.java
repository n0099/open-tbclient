package com.baidu.tieba.ala.alaar.sticker.a;

import android.text.TextUtils;
import android.util.ArrayMap;
import com.baidu.tieba.ala.alaar.sticker.model.d;
import java.io.File;
/* loaded from: classes4.dex */
public class c<T extends com.baidu.tieba.ala.alaar.sticker.model.d> {
    private static c fmN;
    private static c fmO;
    private ArrayMap<String, T> fmP = new ArrayMap<>();
    private File mFolder;

    public static c<com.baidu.tieba.ala.alaar.sticker.model.b> bvG() {
        if (fmN == null) {
            fmN = bvH();
        }
        return fmN;
    }

    private static synchronized c<com.baidu.tieba.ala.alaar.sticker.model.b> bvH() {
        c<com.baidu.tieba.ala.alaar.sticker.model.b> cVar;
        synchronized (c.class) {
            if (fmN == null) {
                fmN = new c(a.bvB().bvD());
            }
            cVar = fmN;
        }
        return cVar;
    }

    public static c<com.baidu.tieba.ala.alaar.sticker.model.c> bvF() {
        if (fmO == null) {
            fmO = bvI();
        }
        return fmO;
    }

    private static synchronized c<com.baidu.tieba.ala.alaar.sticker.model.c> bvI() {
        c<com.baidu.tieba.ala.alaar.sticker.model.c> cVar;
        synchronized (c.class) {
            if (fmO == null) {
                fmO = new c(a.bvB().bvE());
            }
            cVar = fmO;
        }
        return cVar;
    }

    private c(File file) {
        this.mFolder = file;
    }

    public T BJ(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.fmP.get(str);
    }

    public T a(String str, T t) {
        return this.fmP.put(str, t);
    }

    public void a(String str, com.baidu.tieba.ala.alaar.sticker.download.a.a aVar) {
        T t;
        if (!TextUtils.isEmpty(str) && (t = this.fmP.get(str)) != null) {
            t.b(aVar);
        }
    }
}
