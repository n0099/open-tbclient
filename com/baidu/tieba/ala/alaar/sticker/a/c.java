package com.baidu.tieba.ala.alaar.sticker.a;

import android.text.TextUtils;
import android.util.ArrayMap;
import com.baidu.tieba.ala.alaar.sticker.model.d;
import java.io.File;
/* loaded from: classes3.dex */
public class c<T extends com.baidu.tieba.ala.alaar.sticker.model.d> {
    private static c eWY;
    private static c eWZ;
    private ArrayMap<String, T> eXa = new ArrayMap<>();
    private File mFolder;

    public static c<com.baidu.tieba.ala.alaar.sticker.model.b> bpL() {
        if (eWY == null) {
            eWY = bpM();
        }
        return eWY;
    }

    private static synchronized c<com.baidu.tieba.ala.alaar.sticker.model.b> bpM() {
        c<com.baidu.tieba.ala.alaar.sticker.model.b> cVar;
        synchronized (c.class) {
            if (eWY == null) {
                eWY = new c(a.bpG().bpI());
            }
            cVar = eWY;
        }
        return cVar;
    }

    public static c<com.baidu.tieba.ala.alaar.sticker.model.c> bpK() {
        if (eWZ == null) {
            eWZ = bpN();
        }
        return eWZ;
    }

    private static synchronized c<com.baidu.tieba.ala.alaar.sticker.model.c> bpN() {
        c<com.baidu.tieba.ala.alaar.sticker.model.c> cVar;
        synchronized (c.class) {
            if (eWZ == null) {
                eWZ = new c(a.bpG().bpJ());
            }
            cVar = eWZ;
        }
        return cVar;
    }

    private c(File file) {
        this.mFolder = file;
    }

    public T AF(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.eXa.get(str);
    }

    public T a(String str, T t) {
        return this.eXa.put(str, t);
    }

    public void a(String str, com.baidu.tieba.ala.alaar.sticker.download.a.a aVar) {
        T t;
        if (!TextUtils.isEmpty(str) && (t = this.eXa.get(str)) != null) {
            t.b(aVar);
        }
    }
}
