package com.baidu.tbadk.img.effect;

import android.graphics.Bitmap;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    private static c awM = new c();
    private final HashMap<String, Class<? extends b>> awN = new HashMap<>();

    public static c CT() {
        return awM;
    }

    private c() {
        h(d.class);
        h(f.class);
        h(a.class);
        h(e.class);
    }

    public Bitmap a(Bitmap bitmap, boolean z, List<ImageOperation> list) {
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

    public Bitmap d(String str, List<ImageOperation> list) {
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
        Bitmap fM = dVar != null ? dVar.fM(str) : null;
        if (list == null) {
            return fM;
        }
        while (true) {
            Bitmap bitmap = fM;
            if (i2 < list.size()) {
                b a = a(list.get(i2));
                if (a == null) {
                    fM = bitmap;
                } else if (bitmap == null) {
                    fM = a.fM(str);
                } else {
                    fM = a.b(bitmap, true);
                }
                i2++;
            } else {
                return bitmap;
            }
        }
    }

    protected b a(ImageOperation imageOperation) {
        b i;
        Class<? extends b> cls = this.awN.get(imageOperation.actionName);
        if (cls != null && (i = i(cls)) != null) {
            i.fL(imageOperation.actionParam);
            return i;
        }
        return null;
    }

    private void h(Class<? extends b> cls) {
        b i = i(cls);
        if (i != null) {
            this.awN.put(i.getActionName(), cls);
        }
    }

    private b i(Class<? extends b> cls) {
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
