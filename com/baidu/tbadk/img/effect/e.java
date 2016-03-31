package com.baidu.tbadk.img.effect;

import android.graphics.Bitmap;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
/* loaded from: classes.dex */
public class e extends b {
    private int aym = 0;

    @Override // com.baidu.tbadk.img.effect.b
    public String EV() {
        return "rotate";
    }

    public static ImageOperation eU(int i) {
        ImageOperation imageOperation = new ImageOperation();
        imageOperation.actionName = "rotate";
        imageOperation.actionParam = String.valueOf(i);
        return imageOperation;
    }

    @Override // com.baidu.tbadk.img.effect.b
    public void setParams(String str) {
        if (str != null) {
            this.aym = Integer.parseInt(str);
        }
    }

    @Override // com.baidu.tbadk.img.effect.b
    public Bitmap b(Bitmap bitmap, boolean z) {
        if (bitmap == null) {
            return null;
        }
        com.baidu.tbadk.imageManager.c.EO().eT(BitmapHelper.getBitmapSize(bitmap) * 2);
        if (this.aym == 0 || this.aym == 1) {
            return BitmapHelper.rotateBitmap(bitmap, this.aym);
        }
        if (this.aym == 2 || this.aym == 3) {
            return BitmapHelper.reversalBitmap(bitmap, this.aym);
        }
        return bitmap;
    }

    @Override // com.baidu.tbadk.img.effect.b
    public Bitmap fR(String str) {
        int max = Math.max(k.B(TbadkCoreApplication.m411getInst().getApp()), k.C(TbadkCoreApplication.m411getInst().getApp()));
        return b(BitmapHelper.loadResizedBitmap(str, max, max), true);
    }
}
