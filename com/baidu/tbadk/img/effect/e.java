package com.baidu.tbadk.img.effect;

import android.graphics.Bitmap;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
/* loaded from: classes.dex */
public class e extends b {
    private int axF = 0;

    @Override // com.baidu.tbadk.img.effect.b
    public String getActionName() {
        return "rotate";
    }

    public static ImageOperation eO(int i) {
        ImageOperation imageOperation = new ImageOperation();
        imageOperation.actionName = "rotate";
        imageOperation.actionParam = String.valueOf(i);
        return imageOperation;
    }

    @Override // com.baidu.tbadk.img.effect.b
    public void fJ(String str) {
        if (str != null) {
            this.axF = Integer.parseInt(str);
        }
    }

    @Override // com.baidu.tbadk.img.effect.b
    public Bitmap b(Bitmap bitmap, boolean z) {
        if (bitmap == null) {
            return null;
        }
        com.baidu.tbadk.imageManager.c.Ed().eN(BitmapHelper.getBitmapSize(bitmap) * 2);
        if (this.axF == 0 || this.axF == 1) {
            return BitmapHelper.rotateBitmap(bitmap, this.axF);
        }
        if (this.axF == 2 || this.axF == 3) {
            return BitmapHelper.reversalBitmap(bitmap, this.axF);
        }
        return bitmap;
    }

    @Override // com.baidu.tbadk.img.effect.b
    public Bitmap fK(String str) {
        int max = Math.max(k.K(TbadkCoreApplication.m411getInst().getApp()), k.L(TbadkCoreApplication.m411getInst().getApp()));
        return b(BitmapHelper.loadResizedBitmap(str, max, max), true);
    }
}
