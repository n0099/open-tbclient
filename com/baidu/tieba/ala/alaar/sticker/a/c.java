package com.baidu.tieba.ala.alaar.sticker.a;

import android.text.TextUtils;
import android.util.ArrayMap;
import com.baidu.tieba.ala.alaar.sticker.model.d;
import java.io.File;
/* loaded from: classes3.dex */
public class c<T extends com.baidu.tieba.ala.alaar.sticker.model.d> {
    private static c eXj;
    private static c eXk;
    private ArrayMap<String, T> eXl = new ArrayMap<>();
    private File mFolder;

    public static c<com.baidu.tieba.ala.alaar.sticker.model.b> bpN() {
        if (eXj == null) {
            eXj = bpO();
        }
        return eXj;
    }

    private static synchronized c<com.baidu.tieba.ala.alaar.sticker.model.b> bpO() {
        c<com.baidu.tieba.ala.alaar.sticker.model.b> cVar;
        synchronized (c.class) {
            if (eXj == null) {
                eXj = new c(a.bpI().bpK());
            }
            cVar = eXj;
        }
        return cVar;
    }

    public static c<com.baidu.tieba.ala.alaar.sticker.model.c> bpM() {
        if (eXk == null) {
            eXk = bpP();
        }
        return eXk;
    }

    private static synchronized c<com.baidu.tieba.ala.alaar.sticker.model.c> bpP() {
        c<com.baidu.tieba.ala.alaar.sticker.model.c> cVar;
        synchronized (c.class) {
            if (eXk == null) {
                eXk = new c(a.bpI().bpL());
            }
            cVar = eXk;
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
        return this.eXl.get(str);
    }

    public T a(String str, T t) {
        return this.eXl.put(str, t);
    }

    public void a(String str, com.baidu.tieba.ala.alaar.sticker.download.a.a aVar) {
        T t;
        if (!TextUtils.isEmpty(str) && (t = this.eXl.get(str)) != null) {
            t.b(aVar);
        }
    }
}
