package com.baidu.tbadk.img.effect;

import android.graphics.Bitmap;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    private static c ayA = new c();
    private final HashMap<String, Class<? extends b>> ayB = new HashMap<>();

    public static c Er() {
        return ayA;
    }

    private c() {
        r(d.class);
        r(f.class);
        r(a.class);
        r(e.class);
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
        Bitmap fZ = dVar != null ? dVar.fZ(str) : null;
        if (list == null) {
            return fZ;
        }
        while (true) {
            Bitmap bitmap = fZ;
            if (i2 < list.size()) {
                b a = a(list.get(i2));
                if (a == null) {
                    fZ = bitmap;
                } else if (bitmap == null) {
                    fZ = a.fZ(str);
                } else {
                    fZ = a.b(bitmap, true);
                }
                i2++;
            } else {
                return bitmap;
            }
        }
    }

    protected b a(ImageOperation imageOperation) {
        b s;
        Class<? extends b> cls = this.ayB.get(imageOperation.actionName);
        if (cls != null && (s = s(cls)) != null) {
            s.setParams(imageOperation.actionParam);
            return s;
        }
        return null;
    }

    private void r(Class<? extends b> cls) {
        b s = s(cls);
        if (s != null) {
            this.ayB.put(s.getActionName(), cls);
        }
    }

    private b s(Class<? extends b> cls) {
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
