package com.baidu.tieba.ala.alaar.sticker.a;

import android.text.TextUtils;
import android.util.ArrayMap;
import com.baidu.tieba.ala.alaar.sticker.model.d;
import java.io.File;
/* loaded from: classes3.dex */
public class c<T extends com.baidu.tieba.ala.alaar.sticker.model.d> {
    private static c fhE;
    private static c fhF;
    private ArrayMap<String, T> fhG = new ArrayMap<>();
    private File mFolder;

    public static c<com.baidu.tieba.ala.alaar.sticker.model.b> bsw() {
        if (fhE == null) {
            fhE = bsx();
        }
        return fhE;
    }

    private static synchronized c<com.baidu.tieba.ala.alaar.sticker.model.b> bsx() {
        c<com.baidu.tieba.ala.alaar.sticker.model.b> cVar;
        synchronized (c.class) {
            if (fhE == null) {
                fhE = new c(a.bsr().bst());
            }
            cVar = fhE;
        }
        return cVar;
    }

    public static c<com.baidu.tieba.ala.alaar.sticker.model.c> bsv() {
        if (fhF == null) {
            fhF = bsy();
        }
        return fhF;
    }

    private static synchronized c<com.baidu.tieba.ala.alaar.sticker.model.c> bsy() {
        c<com.baidu.tieba.ala.alaar.sticker.model.c> cVar;
        synchronized (c.class) {
            if (fhF == null) {
                fhF = new c(a.bsr().bsu());
            }
            cVar = fhF;
        }
        return cVar;
    }

    private c(File file) {
        this.mFolder = file;
    }

    public T AY(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.fhG.get(str);
    }

    public T a(String str, T t) {
        return this.fhG.put(str, t);
    }

    public void a(String str, com.baidu.tieba.ala.alaar.sticker.download.a.a aVar) {
        T t;
        if (!TextUtils.isEmpty(str) && (t = this.fhG.get(str)) != null) {
            t.b(aVar);
        }
    }
}
