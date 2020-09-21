package com.baidu.tieba.ala.alaar.sticker.a;

import android.text.TextUtils;
import android.util.ArrayMap;
import com.baidu.tieba.ala.alaar.sticker.model.d;
import java.io.File;
/* loaded from: classes4.dex */
public class c<T extends com.baidu.tieba.ala.alaar.sticker.model.d> {
    private static c fBy;
    private static c fBz;
    private ArrayMap<String, T> fBA = new ArrayMap<>();
    private File mFolder;

    public static c<com.baidu.tieba.ala.alaar.sticker.model.b> bFS() {
        if (fBy == null) {
            fBy = bFT();
        }
        return fBy;
    }

    private static synchronized c<com.baidu.tieba.ala.alaar.sticker.model.b> bFT() {
        c<com.baidu.tieba.ala.alaar.sticker.model.b> cVar;
        synchronized (c.class) {
            if (fBy == null) {
                fBy = new c(a.bFN().bFP());
            }
            cVar = fBy;
        }
        return cVar;
    }

    public static c<com.baidu.tieba.ala.alaar.sticker.model.c> bFR() {
        if (fBz == null) {
            fBz = bFU();
        }
        return fBz;
    }

    private static synchronized c<com.baidu.tieba.ala.alaar.sticker.model.c> bFU() {
        c<com.baidu.tieba.ala.alaar.sticker.model.c> cVar;
        synchronized (c.class) {
            if (fBz == null) {
                fBz = new c(a.bFN().bFQ());
            }
            cVar = fBz;
        }
        return cVar;
    }

    private c(File file) {
        this.mFolder = file;
    }

    public T EB(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.fBA.get(str);
    }

    public T a(String str, T t) {
        return this.fBA.put(str, t);
    }

    public void a(String str, com.baidu.tieba.ala.alaar.sticker.download.a.a aVar) {
        T t;
        if (!TextUtils.isEmpty(str) && (t = this.fBA.get(str)) != null) {
            t.b(aVar);
        }
    }
}
