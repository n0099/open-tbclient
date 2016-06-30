package com.baidu.tbadk.img.effect;

import android.graphics.Bitmap;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
/* loaded from: classes.dex */
public class e extends b {
    private int avd = 0;

    @Override // com.baidu.tbadk.img.effect.b
    public String getActionName() {
        return "rotate";
    }

    public static ImageOperation eE(int i) {
        ImageOperation imageOperation = new ImageOperation();
        imageOperation.actionName = "rotate";
        imageOperation.actionParam = String.valueOf(i);
        return imageOperation;
    }

    @Override // com.baidu.tbadk.img.effect.b
    public void setParams(String str) {
        if (str != null) {
            this.avd = Integer.parseInt(str);
        }
    }

    @Override // com.baidu.tbadk.img.effect.b
    public Bitmap b(Bitmap bitmap, boolean z) {
        if (bitmap == null) {
            return null;
        }
        com.baidu.tbadk.imageManager.c.CQ().eD(BitmapHelper.getBitmapSize(bitmap) * 2);
        if (this.avd == 0 || this.avd == 1) {
            return BitmapHelper.rotateBitmap(bitmap, this.avd);
        }
        if (this.avd == 2 || this.avd == 3) {
            return BitmapHelper.reversalBitmap(bitmap, this.avd);
        }
        return bitmap;
    }

    @Override // com.baidu.tbadk.img.effect.b
    public Bitmap fU(String str) {
        int max = Math.max(k.A(TbadkCoreApplication.m9getInst().getApp()), k.B(TbadkCoreApplication.m9getInst().getApp()));
        return b(BitmapHelper.loadResizedBitmap(str, max, max), true);
    }
}
