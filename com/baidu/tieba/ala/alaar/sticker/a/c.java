package com.baidu.tieba.ala.alaar.sticker.a;

import android.text.TextUtils;
import android.util.ArrayMap;
import com.baidu.tieba.ala.alaar.sticker.model.d;
import java.io.File;
/* loaded from: classes7.dex */
public class c<T extends com.baidu.tieba.ala.alaar.sticker.model.d> {
    private static c fyi;
    private static c fyj;
    private ArrayMap<String, T> fyk = new ArrayMap<>();
    private File mFolder;

    public static c<com.baidu.tieba.ala.alaar.sticker.model.b> bEB() {
        if (fyi == null) {
            fyi = bEC();
        }
        return fyi;
    }

    private static synchronized c<com.baidu.tieba.ala.alaar.sticker.model.b> bEC() {
        c<com.baidu.tieba.ala.alaar.sticker.model.b> cVar;
        synchronized (c.class) {
            if (fyi == null) {
                fyi = new c(a.bEw().bEy());
            }
            cVar = fyi;
        }
        return cVar;
    }

    public static c<com.baidu.tieba.ala.alaar.sticker.model.c> bEA() {
        if (fyj == null) {
            fyj = bED();
        }
        return fyj;
    }

    private static synchronized c<com.baidu.tieba.ala.alaar.sticker.model.c> bED() {
        c<com.baidu.tieba.ala.alaar.sticker.model.c> cVar;
        synchronized (c.class) {
            if (fyj == null) {
                fyj = new c(a.bEw().bEz());
            }
            cVar = fyj;
        }
        return cVar;
    }

    private c(File file) {
        this.mFolder = file;
    }

    public T Ed(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.fyk.get(str);
    }

    public T a(String str, T t) {
        return this.fyk.put(str, t);
    }

    public void a(String str, com.baidu.tieba.ala.alaar.sticker.download.a.a aVar) {
        T t;
        if (!TextUtils.isEmpty(str) && (t = this.fyk.get(str)) != null) {
            t.b(aVar);
        }
    }
}
