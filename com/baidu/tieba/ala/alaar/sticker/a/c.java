package com.baidu.tieba.ala.alaar.sticker.a;

import android.text.TextUtils;
import android.util.ArrayMap;
import com.baidu.tieba.ala.alaar.sticker.model.d;
import java.io.File;
/* loaded from: classes4.dex */
public class c<T extends com.baidu.tieba.ala.alaar.sticker.model.d> {
    private static c fNH;
    private static c fNI;
    private ArrayMap<String, T> fNJ = new ArrayMap<>();
    private File mFolder;

    public static c<com.baidu.tieba.ala.alaar.sticker.model.b> bIE() {
        if (fNH == null) {
            fNH = bIF();
        }
        return fNH;
    }

    private static synchronized c<com.baidu.tieba.ala.alaar.sticker.model.b> bIF() {
        c<com.baidu.tieba.ala.alaar.sticker.model.b> cVar;
        synchronized (c.class) {
            if (fNH == null) {
                fNH = new c(a.bIz().bIB());
            }
            cVar = fNH;
        }
        return cVar;
    }

    public static c<com.baidu.tieba.ala.alaar.sticker.model.c> bID() {
        if (fNI == null) {
            fNI = bIG();
        }
        return fNI;
    }

    private static synchronized c<com.baidu.tieba.ala.alaar.sticker.model.c> bIG() {
        c<com.baidu.tieba.ala.alaar.sticker.model.c> cVar;
        synchronized (c.class) {
            if (fNI == null) {
                fNI = new c(a.bIz().bIC());
            }
            cVar = fNI;
        }
        return cVar;
    }

    private c(File file) {
        this.mFolder = file;
    }

    public T Fm(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.fNJ.get(str);
    }

    public T a(String str, T t) {
        return this.fNJ.put(str, t);
    }

    public void a(String str, com.baidu.tieba.ala.alaar.sticker.download.a.a aVar) {
        T t;
        if (!TextUtils.isEmpty(str) && (t = this.fNJ.get(str)) != null) {
            t.b(aVar);
        }
    }
}
