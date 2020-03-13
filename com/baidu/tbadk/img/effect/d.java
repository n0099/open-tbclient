package com.baidu.tbadk.img.effect;

import android.graphics.Bitmap;
import com.baidu.live.tbadk.img.effect.ResizeImageAction;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes.dex */
public class d extends b {
    private int maxHeight;
    private int maxWidth;

    @Override // com.baidu.tbadk.img.effect.b
    public String getActionName() {
        return ResizeImageAction.ACTION_NAME;
    }

    public static ImageOperation aJ(int i, int i2) {
        ImageOperation imageOperation = new ImageOperation();
        imageOperation.actionName = ResizeImageAction.ACTION_NAME;
        imageOperation.actionParam = i + Constants.ACCEPT_TIME_SEPARATOR_SP + i2;
        return imageOperation;
    }

    @Override // com.baidu.tbadk.img.effect.b
    public void setParams(String str) {
        if (str != null) {
            String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            if (split.length == 2) {
                this.maxWidth = com.baidu.adp.lib.f.b.toInt(split[0], 0);
                this.maxHeight = com.baidu.adp.lib.f.b.toInt(split[1], 0);
            }
        }
    }

    @Override // com.baidu.tbadk.img.effect.b
    public Bitmap processImage(Bitmap bitmap, boolean z) throws Exception {
        if (bitmap == null) {
            return null;
        }
        com.baidu.tbadk.imageManager.c.aPR().freePicCache(BitmapHelper.getBitmapSize(bitmap) * 2);
        return BitmapHelper.resizeBitmap(bitmap, this.maxWidth, this.maxHeight, z);
    }

    @Override // com.baidu.tbadk.img.effect.b
    public Bitmap processImage(String str) throws Exception {
        return processImage(BitmapHelper.loadResizedBitmap(str, this.maxWidth, this.maxHeight), true);
    }

    public int getMaxWidth() {
        return this.maxWidth;
    }

    public int getMaxHeight() {
        return this.maxHeight;
    }
}
