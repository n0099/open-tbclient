package com.baidu.tbadk.img.effect;

import android.graphics.Bitmap;
/* loaded from: classes.dex */
public class d extends b {
    private int maxHeight;
    private int maxWidth;

    @Override // com.baidu.tbadk.img.effect.b
    public String sr() {
        return "resize";
    }

    public static ImageOperation w(int i, int i2) {
        ImageOperation imageOperation = new ImageOperation();
        imageOperation.actionName = "resize";
        imageOperation.actionParam = String.valueOf(i) + "," + i2;
        return imageOperation;
    }

    @Override // com.baidu.tbadk.img.effect.b
    public void dw(String str) {
        if (str != null) {
            String[] split = str.split(",");
            if (split.length == 2) {
                this.maxWidth = com.baidu.adp.lib.g.c.f(split[0], 0);
                this.maxHeight = com.baidu.adp.lib.g.c.f(split[1], 0);
            }
        }
    }

    @Override // com.baidu.tbadk.img.effect.b
    public Bitmap b(Bitmap bitmap, boolean z) {
        if (bitmap == null) {
            return null;
        }
        com.baidu.tbadk.imageManager.e.si().cR(com.baidu.tbadk.core.util.d.a(bitmap) * 2);
        return com.baidu.tbadk.core.util.d.a(bitmap, this.maxWidth, this.maxHeight, z);
    }

    @Override // com.baidu.tbadk.img.effect.b
    public Bitmap dx(String str) {
        return b(com.baidu.tbadk.core.util.d.a(str, this.maxWidth, this.maxHeight), true);
    }

    public int getMaxWidth() {
        return this.maxWidth;
    }

    public int st() {
        return this.maxHeight;
    }
}
