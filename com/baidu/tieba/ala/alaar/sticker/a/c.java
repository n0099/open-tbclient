package com.baidu.tieba.ala.alaar.sticker.a;

import android.text.TextUtils;
import android.util.ArrayMap;
import com.baidu.tieba.ala.alaar.sticker.model.e;
import java.io.File;
/* loaded from: classes4.dex */
public class c<T extends com.baidu.tieba.ala.alaar.sticker.model.e> {
    private static c gkA;
    private static c gkB;
    private ArrayMap<String, T> gkC = new ArrayMap<>();
    private File mFolder;

    public static c<com.baidu.tieba.ala.alaar.sticker.model.b> bQF() {
        if (gkA == null) {
            gkA = bQG();
        }
        return gkA;
    }

    private static synchronized c<com.baidu.tieba.ala.alaar.sticker.model.b> bQG() {
        c<com.baidu.tieba.ala.alaar.sticker.model.b> cVar;
        synchronized (c.class) {
            if (gkA == null) {
                gkA = new c(a.bQA().bQC());
            }
            cVar = gkA;
        }
        return cVar;
    }

    public static c<com.baidu.tieba.ala.alaar.sticker.model.d> bQE() {
        if (gkB == null) {
            gkB = bQH();
        }
        return gkB;
    }

    private static synchronized c<com.baidu.tieba.ala.alaar.sticker.model.d> bQH() {
        c<com.baidu.tieba.ala.alaar.sticker.model.d> cVar;
        synchronized (c.class) {
            if (gkB == null) {
                gkB = new c(a.bQA().bQD());
            }
            cVar = gkB;
        }
        return cVar;
    }

    private c(File file) {
        this.mFolder = file;
    }

    public T Go(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.gkC.get(str);
    }

    public T a(String str, T t) {
        return this.gkC.put(str, t);
    }

    public void a(String str, com.baidu.tieba.ala.alaar.sticker.download.a.a aVar) {
        T t;
        if (!TextUtils.isEmpty(str) && (t = this.gkC.get(str)) != null) {
            t.b(aVar);
        }
    }
}
