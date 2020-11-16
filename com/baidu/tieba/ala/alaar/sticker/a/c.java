package com.baidu.tieba.ala.alaar.sticker.a;

import android.text.TextUtils;
import android.util.ArrayMap;
import com.baidu.tieba.ala.alaar.sticker.model.e;
import java.io.File;
/* loaded from: classes4.dex */
public class c<T extends com.baidu.tieba.ala.alaar.sticker.model.e> {
    private static c gcp;
    private static c gcq;
    private ArrayMap<String, T> gcr = new ArrayMap<>();
    private File mFolder;

    public static c<com.baidu.tieba.ala.alaar.sticker.model.b> bMU() {
        if (gcp == null) {
            gcp = bMV();
        }
        return gcp;
    }

    private static synchronized c<com.baidu.tieba.ala.alaar.sticker.model.b> bMV() {
        c<com.baidu.tieba.ala.alaar.sticker.model.b> cVar;
        synchronized (c.class) {
            if (gcp == null) {
                gcp = new c(a.bMP().bMR());
            }
            cVar = gcp;
        }
        return cVar;
    }

    public static c<com.baidu.tieba.ala.alaar.sticker.model.d> bMT() {
        if (gcq == null) {
            gcq = bMW();
        }
        return gcq;
    }

    private static synchronized c<com.baidu.tieba.ala.alaar.sticker.model.d> bMW() {
        c<com.baidu.tieba.ala.alaar.sticker.model.d> cVar;
        synchronized (c.class) {
            if (gcq == null) {
                gcq = new c(a.bMP().bMS());
            }
            cVar = gcq;
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
        return this.gcr.get(str);
    }

    public T a(String str, T t) {
        return this.gcr.put(str, t);
    }

    public void a(String str, com.baidu.tieba.ala.alaar.sticker.download.a.a aVar) {
        T t;
        if (!TextUtils.isEmpty(str) && (t = this.gcr.get(str)) != null) {
            t.b(aVar);
        }
    }
}
