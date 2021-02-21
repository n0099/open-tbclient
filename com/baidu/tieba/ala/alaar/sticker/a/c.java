package com.baidu.tieba.ala.alaar.sticker.a;

import android.text.TextUtils;
import android.util.ArrayMap;
import com.baidu.tieba.ala.alaar.sticker.model.e;
import java.io.File;
/* loaded from: classes11.dex */
public class c<T extends com.baidu.tieba.ala.alaar.sticker.model.e> {
    private static c gts;
    private static c gtt;
    private ArrayMap<String, T> gtu = new ArrayMap<>();
    private File mFolder;

    public static c<com.baidu.tieba.ala.alaar.sticker.model.b> bPZ() {
        if (gts == null) {
            gts = bQa();
        }
        return gts;
    }

    private static synchronized c<com.baidu.tieba.ala.alaar.sticker.model.b> bQa() {
        c<com.baidu.tieba.ala.alaar.sticker.model.b> cVar;
        synchronized (c.class) {
            if (gts == null) {
                gts = new c(a.bPU().bPW());
            }
            cVar = gts;
        }
        return cVar;
    }

    public static c<com.baidu.tieba.ala.alaar.sticker.model.d> bPY() {
        if (gtt == null) {
            gtt = bQb();
        }
        return gtt;
    }

    private static synchronized c<com.baidu.tieba.ala.alaar.sticker.model.d> bQb() {
        c<com.baidu.tieba.ala.alaar.sticker.model.d> cVar;
        synchronized (c.class) {
            if (gtt == null) {
                gtt = new c(a.bPU().bPX());
            }
            cVar = gtt;
        }
        return cVar;
    }

    private c(File file) {
        this.mFolder = file;
    }

    public T FA(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.gtu.get(str);
    }

    public T a(String str, T t) {
        return this.gtu.put(str, t);
    }

    public void a(String str, com.baidu.tieba.ala.alaar.sticker.download.a.a aVar) {
        T t;
        if (!TextUtils.isEmpty(str) && (t = this.gtu.get(str)) != null) {
            t.b(aVar);
        }
    }
}
