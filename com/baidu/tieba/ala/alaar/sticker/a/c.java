package com.baidu.tieba.ala.alaar.sticker.a;

import android.text.TextUtils;
import android.util.ArrayMap;
import com.baidu.tieba.ala.alaar.sticker.model.e;
import java.io.File;
/* loaded from: classes4.dex */
public class c<T extends com.baidu.tieba.ala.alaar.sticker.model.e> {
    private static c fWR;
    private static c fWS;
    private ArrayMap<String, T> fWT = new ArrayMap<>();
    private File mFolder;

    public static c<com.baidu.tieba.ala.alaar.sticker.model.b> bLc() {
        if (fWR == null) {
            fWR = bLd();
        }
        return fWR;
    }

    private static synchronized c<com.baidu.tieba.ala.alaar.sticker.model.b> bLd() {
        c<com.baidu.tieba.ala.alaar.sticker.model.b> cVar;
        synchronized (c.class) {
            if (fWR == null) {
                fWR = new c(a.bKX().bKZ());
            }
            cVar = fWR;
        }
        return cVar;
    }

    public static c<com.baidu.tieba.ala.alaar.sticker.model.d> bLb() {
        if (fWS == null) {
            fWS = bLe();
        }
        return fWS;
    }

    private static synchronized c<com.baidu.tieba.ala.alaar.sticker.model.d> bLe() {
        c<com.baidu.tieba.ala.alaar.sticker.model.d> cVar;
        synchronized (c.class) {
            if (fWS == null) {
                fWS = new c(a.bKX().bLa());
            }
            cVar = fWS;
        }
        return cVar;
    }

    private c(File file) {
        this.mFolder = file;
    }

    public T FK(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.fWT.get(str);
    }

    public T a(String str, T t) {
        return this.fWT.put(str, t);
    }

    public void a(String str, com.baidu.tieba.ala.alaar.sticker.download.a.a aVar) {
        T t;
        if (!TextUtils.isEmpty(str) && (t = this.fWT.get(str)) != null) {
            t.b(aVar);
        }
    }
}
