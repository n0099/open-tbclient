package com.baidu.tieba.ala.alaar.sticker.a;

import android.text.TextUtils;
import android.util.ArrayMap;
import com.baidu.tieba.ala.alaar.sticker.model.d;
import java.io.File;
/* loaded from: classes3.dex */
public class c<T extends com.baidu.tieba.ala.alaar.sticker.model.d> {
    private static c eKB;
    private static c eKC;
    private ArrayMap<String, T> eKD = new ArrayMap<>();
    private File mFolder;

    public static c<com.baidu.tieba.ala.alaar.sticker.model.b> bkr() {
        if (eKB == null) {
            eKB = bks();
        }
        return eKB;
    }

    private static synchronized c<com.baidu.tieba.ala.alaar.sticker.model.b> bks() {
        c<com.baidu.tieba.ala.alaar.sticker.model.b> cVar;
        synchronized (c.class) {
            if (eKB == null) {
                eKB = new c(a.bkm().bko());
            }
            cVar = eKB;
        }
        return cVar;
    }

    public static c<com.baidu.tieba.ala.alaar.sticker.model.c> bkq() {
        if (eKC == null) {
            eKC = bkt();
        }
        return eKC;
    }

    private static synchronized c<com.baidu.tieba.ala.alaar.sticker.model.c> bkt() {
        c<com.baidu.tieba.ala.alaar.sticker.model.c> cVar;
        synchronized (c.class) {
            if (eKC == null) {
                eKC = new c(a.bkm().bkp());
            }
            cVar = eKC;
        }
        return cVar;
    }

    private c(File file) {
        this.mFolder = file;
    }

    public T yZ(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.eKD.get(str);
    }

    public T a(String str, T t) {
        return this.eKD.put(str, t);
    }

    public void a(String str, com.baidu.tieba.ala.alaar.sticker.download.a.a aVar) {
        T t;
        if (!TextUtils.isEmpty(str) && (t = this.eKD.get(str)) != null) {
            t.b(aVar);
        }
    }
}
