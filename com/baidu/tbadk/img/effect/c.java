package com.baidu.tbadk.img.effect;

import android.graphics.Bitmap;
import com.baidu.live.tbadk.img.effect.ResizeImageAction;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.img.ImageFileInfo;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    private static c fIh = new c();
    private final HashMap<String, Class<? extends b>> imageActions = new HashMap<>();

    public static c bCU() {
        return fIh;
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
        d dVar;
        if (bitmap != null && !y.isEmpty(list)) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                b a2 = a(list.get(i));
                if ((a2 instanceof g) && imageFileInfo != null) {
                    ((g) a2).setPath(imageFileInfo.getFilePath());
                    return a2.processImage(bitmap, z);
                }
            }
            int i2 = 0;
            d dVar2 = null;
            while (i2 < size) {
                ImageOperation imageOperation = list.get(i2);
                if (ResizeImageAction.ACTION_NAME.equals(imageOperation.actionName)) {
                    dVar = (d) a(imageOperation);
                    if (dVar2 != null && dVar.getMaxWidth() > dVar2.getMaxWidth() && dVar.getMaxHeight() > dVar2.getMaxHeight()) {
                        dVar = dVar2;
                    }
                    list.remove(i2);
                    i2--;
                } else {
                    dVar = dVar2;
                }
                i2++;
                dVar2 = dVar;
            }
            Bitmap processImage2 = dVar2 != null ? dVar2.processImage(bitmap, z) : null;
            if (list != null) {
                int i3 = 0;
                while (i3 < size) {
                    b a3 = a(list.get(i3));
                    if (a3 == null) {
                        processImage = processImage2;
                    } else if (processImage2 == null) {
                        return null;
                    } else {
                        processImage = a3.processImage(bitmap, z);
                    }
                    i3++;
                    processImage2 = processImage;
                }
            }
            return processImage2;
        }
        return bitmap;
    }

    public Bitmap a(String str, List<ImageOperation> list, ImageFileInfo imageFileInfo) throws Exception {
        Bitmap bitmap;
        d dVar;
        int i = 0;
        if (y.isEmpty(list)) {
            return null;
        }
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            b a2 = a(list.get(i2));
            if ((a2 instanceof g) && imageFileInfo != null) {
                return a2.processImage(imageFileInfo.getFilePath());
            }
        }
        int i3 = 0;
        d dVar2 = null;
        while (i3 < list.size()) {
            ImageOperation imageOperation = list.get(i3);
            if (ResizeImageAction.ACTION_NAME.equals(imageOperation.actionName)) {
                dVar = (d) a(imageOperation);
                if (dVar2 != null && dVar.getMaxWidth() > dVar2.getMaxWidth() && dVar.getMaxHeight() > dVar2.getMaxHeight()) {
                    dVar = dVar2;
                }
                list.remove(i3);
                i3--;
            } else {
                dVar = dVar2;
            }
            i3++;
            dVar2 = dVar;
        }
        Bitmap processImage = dVar2 != null ? dVar2.processImage(str) : null;
        if (list != null) {
            while (true) {
                bitmap = processImage;
                if (i >= list.size()) {
                    break;
                }
                b a3 = a(list.get(i));
                if (a3 == null) {
                    processImage = bitmap;
                } else if (bitmap == null) {
                    processImage = a3.processImage(str);
                } else {
                    processImage = a3.processImage(bitmap, true);
                }
                i++;
            }
        } else {
            bitmap = processImage;
        }
        return bitmap;
    }

    protected b a(ImageOperation imageOperation) {
        b n;
        Class<? extends b> cls = this.imageActions.get(imageOperation.actionName);
        if (cls != null && (n = n(cls)) != null) {
            n.setParams(imageOperation.actionParam);
            return n;
        }
        return null;
    }

    private void registerImageAction(Class<? extends b> cls) {
        b n = n(cls);
        if (n != null) {
            this.imageActions.put(n.getActionName(), cls);
        }
    }

    private b n(Class<? extends b> cls) {
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
