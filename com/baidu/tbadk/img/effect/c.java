package com.baidu.tbadk.img.effect;

import android.graphics.Bitmap;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    private static c aFE = new c();
    private final HashMap<String, Class<? extends b>> aFF = new HashMap<>();

    public static c EA() {
        return aFE;
    }

    private c() {
        j(d.class);
        j(f.class);
        j(a.class);
        j(e.class);
    }

    public Bitmap a(Bitmap bitmap, boolean z, List<ImageOperation> list) throws Exception {
        d dVar;
        Bitmap bitmap2;
        int i;
        int i2 = 0;
        if (bitmap != null && list != null && !list.isEmpty()) {
            if (list != null) {
                int i3 = 0;
                dVar = null;
                while (i3 < list.size()) {
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
            } else {
                dVar = null;
            }
            Bitmap b = dVar != null ? dVar.b(bitmap, z) : null;
            if (list != null) {
                while (true) {
                    bitmap2 = b;
                    if (i2 >= list.size()) {
                        break;
                    }
                    b a = a(list.get(i2));
                    if (a == null) {
                        b = bitmap2;
                    } else if (bitmap2 == null) {
                        return null;
                    } else {
                        b = a.b(bitmap, z);
                    }
                    i2++;
                }
            } else {
                bitmap2 = b;
            }
            return bitmap2;
        }
        return bitmap;
    }

    public Bitmap c(String str, List<ImageOperation> list) throws Exception {
        d dVar;
        int i;
        int i2 = 0;
        if (list == null || list.isEmpty()) {
            return null;
        }
        if (list != null) {
            int i3 = 0;
            dVar = null;
            while (i3 < list.size()) {
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
        } else {
            dVar = null;
        }
        Bitmap gn = dVar != null ? dVar.gn(str) : null;
        if (list == null) {
            return gn;
        }
        while (true) {
            Bitmap bitmap = gn;
            if (i2 < list.size()) {
                b a = a(list.get(i2));
                if (a == null) {
                    gn = bitmap;
                } else if (bitmap == null) {
                    gn = a.gn(str);
                } else {
                    gn = a.b(bitmap, true);
                }
                i2++;
            } else {
                return bitmap;
            }
        }
    }

    protected b a(ImageOperation imageOperation) {
        b k;
        Class<? extends b> cls = this.aFF.get(imageOperation.actionName);
        if (cls != null && (k = k(cls)) != null) {
            k.setParams(imageOperation.actionParam);
            return k;
        }
        return null;
    }

    private void j(Class<? extends b> cls) {
        b k = k(cls);
        if (k != null) {
            this.aFF.put(k.getActionName(), cls);
        }
    }

    private b k(Class<? extends b> cls) {
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
