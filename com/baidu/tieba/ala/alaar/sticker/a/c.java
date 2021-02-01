package com.baidu.tieba.ala.alaar.sticker.a;

import android.text.TextUtils;
import android.util.ArrayMap;
import com.baidu.tieba.ala.alaar.sticker.model.e;
import java.io.File;
/* loaded from: classes11.dex */
public class c<T extends com.baidu.tieba.ala.alaar.sticker.model.e> {
    private static c gte;
    private static c gtf;
    private ArrayMap<String, T> gtg = new ArrayMap<>();
    private File mFolder;

    public static c<com.baidu.tieba.ala.alaar.sticker.model.b> bPS() {
        if (gte == null) {
            gte = bPT();
        }
        return gte;
    }

    private static synchronized c<com.baidu.tieba.ala.alaar.sticker.model.b> bPT() {
        c<com.baidu.tieba.ala.alaar.sticker.model.b> cVar;
        synchronized (c.class) {
            if (gte == null) {
                gte = new c(a.bPN().bPP());
            }
            cVar = gte;
        }
        return cVar;
    }

    public static c<com.baidu.tieba.ala.alaar.sticker.model.d> bPR() {
        if (gtf == null) {
            gtf = bPU();
        }
        return gtf;
    }

    private static synchronized c<com.baidu.tieba.ala.alaar.sticker.model.d> bPU() {
        c<com.baidu.tieba.ala.alaar.sticker.model.d> cVar;
        synchronized (c.class) {
            if (gtf == null) {
                gtf = new c(a.bPN().bPQ());
            }
            cVar = gtf;
        }
        return cVar;
    }

    private c(File file) {
        this.mFolder = file;
    }

    public T Fz(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.gtg.get(str);
    }

    public T a(String str, T t) {
        return this.gtg.put(str, t);
    }

    public void a(String str, com.baidu.tieba.ala.alaar.sticker.download.a.a aVar) {
        T t;
        if (!TextUtils.isEmpty(str) && (t = this.gtg.get(str)) != null) {
            t.b(aVar);
        }
    }
}
