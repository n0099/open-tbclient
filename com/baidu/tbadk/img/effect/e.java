package com.baidu.tbadk.img.effect;

import android.graphics.Bitmap;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
/* loaded from: classes.dex */
public class e extends b {
    private int aRb = 0;

    @Override // com.baidu.tbadk.img.effect.b
    public String getActionName() {
        return "rotate";
    }

    public static ImageOperation fe(int i) {
        ImageOperation imageOperation = new ImageOperation();
        imageOperation.actionName = "rotate";
        imageOperation.actionParam = String.valueOf(i);
        return imageOperation;
    }

    @Override // com.baidu.tbadk.img.effect.b
    public void setParams(String str) {
        if (str != null) {
            this.aRb = Integer.parseInt(str);
        }
    }

    @Override // com.baidu.tbadk.img.effect.b
    public Bitmap b(Bitmap bitmap, boolean z) throws Exception {
        if (bitmap == null) {
            return null;
        }
        com.baidu.tbadk.imageManager.c.IQ().fd(BitmapHelper.getBitmapSize(bitmap) * 2);
        if (this.aRb == 0 || this.aRb == 1) {
            return BitmapHelper.rotateBitmap(bitmap, this.aRb);
        }
        if (this.aRb == 2 || this.aRb == 3) {
            return BitmapHelper.reversalBitmap(bitmap, this.aRb);
        }
        return bitmap;
    }

    @Override // com.baidu.tbadk.img.effect.b
    public Bitmap hj(String str) throws Exception {
        int max = Math.max(l.ah(TbadkCoreApplication.getInst().getApp()), l.aj(TbadkCoreApplication.getInst().getApp()));
        return b(BitmapHelper.loadResizedBitmap(str, max, max), true);
    }
}
