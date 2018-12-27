package com.baidu.tbadk.img.effect;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.util.BitmapHelper;
/* loaded from: classes.dex */
public class d extends b {
    private int maxHeight;
    private int maxWidth;

    @Override // com.baidu.tbadk.img.effect.b
    public String getActionName() {
        return "resize";
    }

    public static ImageOperation L(int i, int i2) {
        ImageOperation imageOperation = new ImageOperation();
        imageOperation.actionName = "resize";
        imageOperation.actionParam = i + "," + i2;
        return imageOperation;
    }

    @Override // com.baidu.tbadk.img.effect.b
    public void setParams(String str) {
        if (str != null) {
            String[] split = str.split(",");
            if (split.length == 2) {
                this.maxWidth = com.baidu.adp.lib.g.b.l(split[0], 0);
                this.maxHeight = com.baidu.adp.lib.g.b.l(split[1], 0);
            }
        }
    }

    @Override // com.baidu.tbadk.img.effect.b
    public Bitmap b(Bitmap bitmap, boolean z) throws Exception {
        if (bitmap == null) {
            return null;
        }
        com.baidu.tbadk.imageManager.c.Nv().gb(BitmapHelper.getBitmapSize(bitmap) * 2);
        return BitmapHelper.resizeBitmap(bitmap, this.maxWidth, this.maxHeight, z);
    }

    @Override // com.baidu.tbadk.img.effect.b
    public Bitmap in(String str) throws Exception {
        return b(BitmapHelper.loadResizedBitmap(str, this.maxWidth, this.maxHeight), true);
    }

    public int getMaxWidth() {
        return this.maxWidth;
    }

    public int getMaxHeight() {
        return this.maxHeight;
    }
}
