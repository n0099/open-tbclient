package com.baidu.tieba.ala.alaar.sticker.a;

import android.text.TextUtils;
import android.util.ArrayMap;
import com.baidu.tieba.ala.alaar.sticker.model.d;
import java.io.File;
/* loaded from: classes7.dex */
public class c<T extends com.baidu.tieba.ala.alaar.sticker.model.d> {
    private static c fym;
    private static c fyn;
    private ArrayMap<String, T> fyo = new ArrayMap<>();
    private File mFolder;

    public static c<com.baidu.tieba.ala.alaar.sticker.model.b> bEC() {
        if (fym == null) {
            fym = bED();
        }
        return fym;
    }

    private static synchronized c<com.baidu.tieba.ala.alaar.sticker.model.b> bED() {
        c<com.baidu.tieba.ala.alaar.sticker.model.b> cVar;
        synchronized (c.class) {
            if (fym == null) {
                fym = new c(a.bEx().bEz());
            }
            cVar = fym;
        }
        return cVar;
    }

    public static c<com.baidu.tieba.ala.alaar.sticker.model.c> bEB() {
        if (fyn == null) {
            fyn = bEE();
        }
        return fyn;
    }

    private static synchronized c<com.baidu.tieba.ala.alaar.sticker.model.c> bEE() {
        c<com.baidu.tieba.ala.alaar.sticker.model.c> cVar;
        synchronized (c.class) {
            if (fyn == null) {
                fyn = new c(a.bEx().bEA());
            }
            cVar = fyn;
        }
        return cVar;
    }

    private c(File file) {
        this.mFolder = file;
    }

    public T Ee(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.fyo.get(str);
    }

    public T a(String str, T t) {
        return this.fyo.put(str, t);
    }

    public void a(String str, com.baidu.tieba.ala.alaar.sticker.download.a.a aVar) {
        T t;
        if (!TextUtils.isEmpty(str) && (t = this.fyo.get(str)) != null) {
            t.b(aVar);
        }
    }
}
