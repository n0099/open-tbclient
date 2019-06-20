package com.baidu.tbadk.img.effect;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.img.ImageFileInfo;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    private static c cvB = new c();
    private final HashMap<String, Class<? extends b>> cvC = new HashMap<>();

    public static c asA() {
        return cvB;
    }

    private c() {
        o(d.class);
        o(f.class);
        o(a.class);
        o(e.class);
        o(g.class);
    }

    public Bitmap a(Bitmap bitmap, boolean z, List<ImageOperation> list, ImageFileInfo imageFileInfo) throws Exception {
        Bitmap b;
        int i;
        if (bitmap != null && !v.aa(list)) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                b a = a(list.get(i2));
                if ((a instanceof g) && imageFileInfo != null) {
                    ((g) a).setPath(imageFileInfo.getFilePath());
                    return a.b(bitmap, z);
                }
            }
            int i3 = 0;
            d dVar = null;
            while (i3 < size) {
                ImageOperation imageOperation = list.get(i3);
                if ("resize".equals(imageOperation.actionName)) {
                    d dVar2 = (d) a(imageOperation);
                    if (dVar != null && dVar2.getMaxWidth() > dVar.getMaxWidth() && dVar2.getMaxHeight() > dVar.getMaxHeight()) {
                        dVar2 = dVar;
                    }
                    list.remove(i3);
                    dVar = dVar2;
                    i = i3 - 1;
                } else {
                    i = i3;
                }
                i3 = i + 1;
            }
            Bitmap b2 = dVar != null ? dVar.b(bitmap, z) : null;
            if (list != null) {
                int i4 = 0;
                while (i4 < size) {
                    b a2 = a(list.get(i4));
                    if (a2 == null) {
                        b = b2;
                    } else if (b2 == null) {
                        return null;
                    } else {
                        b = a2.b(bitmap, z);
                    }
                    i4++;
                    b2 = b;
                }
            }
            return b2;
        }
        return bitmap;
    }

    public Bitmap a(String str, List<ImageOperation> list, ImageFileInfo imageFileInfo) throws Exception {
        Bitmap bitmap;
        int i;
        int i2 = 0;
        if (v.aa(list)) {
            return null;
        }
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            b a = a(list.get(i3));
            if ((a instanceof g) && imageFileInfo != null) {
                return a.qv(imageFileInfo.getFilePath());
            }
        }
        int i4 = 0;
        d dVar = null;
        while (i4 < list.size()) {
            ImageOperation imageOperation = list.get(i4);
            if ("resize".equals(imageOperation.actionName)) {
                d dVar2 = (d) a(imageOperation);
                if (dVar != null && dVar2.getMaxWidth() > dVar.getMaxWidth() && dVar2.getMaxHeight() > dVar.getMaxHeight()) {
                    dVar2 = dVar;
                }
                list.remove(i4);
                dVar = dVar2;
                i = i4 - 1;
            } else {
                i = i4;
            }
            i4 = i + 1;
        }
        Bitmap qv = dVar != null ? dVar.qv(str) : null;
        if (list != null) {
            while (true) {
                bitmap = qv;
                if (i2 >= list.size()) {
                    break;
                }
                b a2 = a(list.get(i2));
                if (a2 == null) {
                    qv = bitmap;
                } else if (bitmap == null) {
                    qv = a2.qv(str);
                } else {
                    qv = a2.b(bitmap, true);
                }
                i2++;
            }
        } else {
            bitmap = qv;
        }
        return bitmap;
    }

    protected b a(ImageOperation imageOperation) {
        b p;
        Class<? extends b> cls = this.cvC.get(imageOperation.actionName);
        if (cls != null && (p = p(cls)) != null) {
            p.setParams(imageOperation.actionParam);
            return p;
        }
        return null;
    }

    private void o(Class<? extends b> cls) {
        b p = p(cls);
        if (p != null) {
            this.cvC.put(p.getActionName(), cls);
        }
    }

    private b p(Class<? extends b> cls) {
        try {
            return cls.newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        } catch (InstantiationException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
