package com.baidu.tieba.ala.alaar.sticker.a;

import android.text.TextUtils;
import android.util.ArrayMap;
import com.baidu.tieba.ala.alaar.sticker.model.e;
import java.io.File;
/* loaded from: classes4.dex */
public class c<T extends com.baidu.tieba.ala.alaar.sticker.model.e> {
    private static c gcI;
    private static c gcJ;
    private ArrayMap<String, T> gcK = new ArrayMap<>();
    private File mFolder;

    public static c<com.baidu.tieba.ala.alaar.sticker.model.b> bNB() {
        if (gcI == null) {
            gcI = bNC();
        }
        return gcI;
    }

    private static synchronized c<com.baidu.tieba.ala.alaar.sticker.model.b> bNC() {
        c<com.baidu.tieba.ala.alaar.sticker.model.b> cVar;
        synchronized (c.class) {
            if (gcI == null) {
                gcI = new c(a.bNw().bNy());
            }
            cVar = gcI;
        }
        return cVar;
    }

    public static c<com.baidu.tieba.ala.alaar.sticker.model.d> bNA() {
        if (gcJ == null) {
            gcJ = bND();
        }
        return gcJ;
    }

    private static synchronized c<com.baidu.tieba.ala.alaar.sticker.model.d> bND() {
        c<com.baidu.tieba.ala.alaar.sticker.model.d> cVar;
        synchronized (c.class) {
            if (gcJ == null) {
                gcJ = new c(a.bNw().bNz());
            }
            cVar = gcJ;
        }
        return cVar;
    }

    private c(File file) {
        this.mFolder = file;
    }

    public T FY(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.gcK.get(str);
    }

    public T a(String str, T t) {
        return this.gcK.put(str, t);
    }

    public void a(String str, com.baidu.tieba.ala.alaar.sticker.download.a.a aVar) {
        T t;
        if (!TextUtils.isEmpty(str) && (t = this.gcK.get(str)) != null) {
            t.b(aVar);
        }
    }
}
