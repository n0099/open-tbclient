package com.baidu.tieba.ala.alaar.sticker.a;

import android.text.TextUtils;
import android.util.ArrayMap;
import com.baidu.tieba.ala.alaar.sticker.model.d;
import java.io.File;
/* loaded from: classes3.dex */
public class c<T extends com.baidu.tieba.ala.alaar.sticker.model.d> {
    private static c eKw;
    private static c eKx;
    private ArrayMap<String, T> eKy = new ArrayMap<>();
    private File mFolder;

    public static c<com.baidu.tieba.ala.alaar.sticker.model.b> bkt() {
        if (eKw == null) {
            eKw = bku();
        }
        return eKw;
    }

    private static synchronized c<com.baidu.tieba.ala.alaar.sticker.model.b> bku() {
        c<com.baidu.tieba.ala.alaar.sticker.model.b> cVar;
        synchronized (c.class) {
            if (eKw == null) {
                eKw = new c(a.bko().bkq());
            }
            cVar = eKw;
        }
        return cVar;
    }

    public static c<com.baidu.tieba.ala.alaar.sticker.model.c> bks() {
        if (eKx == null) {
            eKx = bkv();
        }
        return eKx;
    }

    private static synchronized c<com.baidu.tieba.ala.alaar.sticker.model.c> bkv() {
        c<com.baidu.tieba.ala.alaar.sticker.model.c> cVar;
        synchronized (c.class) {
            if (eKx == null) {
                eKx = new c(a.bko().bkr());
            }
            cVar = eKx;
        }
        return cVar;
    }

    private c(File file) {
        this.mFolder = file;
    }

    public T yW(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.eKy.get(str);
    }

    public T a(String str, T t) {
        return this.eKy.put(str, t);
    }

    public void a(String str, com.baidu.tieba.ala.alaar.sticker.download.a.a aVar) {
        T t;
        if (!TextUtils.isEmpty(str) && (t = this.eKy.get(str)) != null) {
            t.b(aVar);
        }
    }
}
