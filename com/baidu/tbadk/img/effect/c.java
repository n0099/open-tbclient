package com.baidu.tbadk.img.effect;

import android.graphics.Bitmap;
import com.baidu.live.tbadk.img.effect.ResizeImageAction;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.img.ImageFileInfo;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    private static c cJM = new c();
    private final HashMap<String, Class<? extends b>> imageActions = new HashMap<>();

    public static c avw() {
        return cJM;
    }

    private c() {
        registerImageAction(d.class);
        registerImageAction(f.class);
        registerImageAction(a.class);
        registerImageAction(e.class);
        registerImageAction(g.class);
    }

    public Bitmap a(Bitmap bitmap, boolean z, List<ImageOperation> list, ImageFileInfo imageFileInfo) throws Exception {
        Bitmap processImage;
        int i;
        if (bitmap != null && !v.isEmpty(list)) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                b a = a(list.get(i2));
                if ((a instanceof g) && imageFileInfo != null) {
                    ((g) a).setPath(imageFileInfo.getFilePath());
                    return a.processImage(bitmap, z);
                }
            }
            int i3 = 0;
            d dVar = null;
            while (i3 < size) {
                ImageOperation imageOperation = list.get(i3);
                if (ResizeImageAction.ACTION_NAME.equals(imageOperation.actionName)) {
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
            Bitmap processImage2 = dVar != null ? dVar.processImage(bitmap, z) : null;
            if (list != null) {
                int i4 = 0;
                while (i4 < size) {
                    b a2 = a(list.get(i4));
                    if (a2 == null) {
                        processImage = processImage2;
                    } else if (processImage2 == null) {
                        return null;
                    } else {
                        processImage = a2.processImage(bitmap, z);
                    }
                    i4++;
                    processImage2 = processImage;
                }
            }
            return processImage2;
        }
        return bitmap;
    }

    public Bitmap a(String str, List<ImageOperation> list, ImageFileInfo imageFileInfo) throws Exception {
        Bitmap bitmap;
        int i;
        int i2 = 0;
        if (v.isEmpty(list)) {
            return null;
        }
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            b a = a(list.get(i3));
            if ((a instanceof g) && imageFileInfo != null) {
                return a.processImage(imageFileInfo.getFilePath());
            }
        }
        int i4 = 0;
        d dVar = null;
        while (i4 < list.size()) {
            ImageOperation imageOperation = list.get(i4);
            if (ResizeImageAction.ACTION_NAME.equals(imageOperation.actionName)) {
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
        Bitmap processImage = dVar != null ? dVar.processImage(str) : null;
        if (list != null) {
            while (true) {
                bitmap = processImage;
                if (i2 >= list.size()) {
                    break;
                }
                b a2 = a(list.get(i2));
                if (a2 == null) {
                    processImage = bitmap;
                } else if (bitmap == null) {
                    processImage = a2.processImage(str);
                } else {
                    processImage = a2.processImage(bitmap, true);
                }
                i2++;
            }
        } else {
            bitmap = processImage;
        }
        return bitmap;
    }

    protected b a(ImageOperation imageOperation) {
        b m;
        Class<? extends b> cls = this.imageActions.get(imageOperation.actionName);
        if (cls != null && (m = m(cls)) != null) {
            m.setParams(imageOperation.actionParam);
            return m;
        }
        return null;
    }

    private void registerImageAction(Class<? extends b> cls) {
        b m = m(cls);
        if (m != null) {
            this.imageActions.put(m.getActionName(), cls);
        }
    }

    private b m(Class<? extends b> cls) {
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
