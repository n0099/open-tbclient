package com.baidu.tieba.ala.alaar.sticker.a;

import android.text.TextUtils;
import android.util.ArrayMap;
import com.baidu.tieba.ala.alaar.sticker.model.e;
import java.io.File;
/* loaded from: classes4.dex */
public class c<T extends com.baidu.tieba.ala.alaar.sticker.model.e> {
    private static c gkC;
    private static c gkD;
    private ArrayMap<String, T> gkE = new ArrayMap<>();
    private File mFolder;

    public static c<com.baidu.tieba.ala.alaar.sticker.model.b> bQG() {
        if (gkC == null) {
            gkC = bQH();
        }
        return gkC;
    }

    private static synchronized c<com.baidu.tieba.ala.alaar.sticker.model.b> bQH() {
        c<com.baidu.tieba.ala.alaar.sticker.model.b> cVar;
        synchronized (c.class) {
            if (gkC == null) {
                gkC = new c(a.bQB().bQD());
            }
            cVar = gkC;
        }
        return cVar;
    }

    public static c<com.baidu.tieba.ala.alaar.sticker.model.d> bQF() {
        if (gkD == null) {
            gkD = bQI();
        }
        return gkD;
    }

    private static synchronized c<com.baidu.tieba.ala.alaar.sticker.model.d> bQI() {
        c<com.baidu.tieba.ala.alaar.sticker.model.d> cVar;
        synchronized (c.class) {
            if (gkD == null) {
                gkD = new c(a.bQB().bQE());
            }
            cVar = gkD;
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
        return this.gkE.get(str);
    }

    public T a(String str, T t) {
        return this.gkE.put(str, t);
    }

    public void a(String str, com.baidu.tieba.ala.alaar.sticker.download.a.a aVar) {
        T t;
        if (!TextUtils.isEmpty(str) && (t = this.gkE.get(str)) != null) {
            t.b(aVar);
        }
    }
}
