package com.baidu.tbadk.img.effect;

import android.graphics.Bitmap;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
/* loaded from: classes.dex */
public class e extends b {
    private int aGq = 0;

    @Override // com.baidu.tbadk.img.effect.b
    public String getActionName() {
        return "rotate";
    }

    public static ImageOperation eY(int i) {
        ImageOperation imageOperation = new ImageOperation();
        imageOperation.actionName = "rotate";
        imageOperation.actionParam = String.valueOf(i);
        return imageOperation;
    }

    @Override // com.baidu.tbadk.img.effect.b
    public void setParams(String str) {
        if (str != null) {
            this.aGq = Integer.parseInt(str);
        }
    }

    @Override // com.baidu.tbadk.img.effect.b
    public Bitmap b(Bitmap bitmap, boolean z) throws Exception {
        if (bitmap == null) {
            return null;
        }
        com.baidu.tbadk.imageManager.c.Ev().eX(BitmapHelper.getBitmapSize(bitmap) * 2);
        if (this.aGq == 0 || this.aGq == 1) {
            return BitmapHelper.rotateBitmap(bitmap, this.aGq);
        }
        if (this.aGq == 2 || this.aGq == 3) {
            return BitmapHelper.reversalBitmap(bitmap, this.aGq);
        }
        return bitmap;
    }

    @Override // com.baidu.tbadk.img.effect.b
    public Bitmap gr(String str) throws Exception {
        int max = Math.max(k.ad(TbadkCoreApplication.getInst().getApp()), k.ae(TbadkCoreApplication.getInst().getApp()));
        return b(BitmapHelper.loadResizedBitmap(str, max, max), true);
    }
}
