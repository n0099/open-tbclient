package com.baidu.tbadk.img.effect;

import android.graphics.Bitmap;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
/* loaded from: classes.dex */
public class e extends b {
    private int aFB = 0;

    @Override // com.baidu.tbadk.img.effect.b
    public String getActionName() {
        return "rotate";
    }

    public static ImageOperation fi(int i) {
        ImageOperation imageOperation = new ImageOperation();
        imageOperation.actionName = "rotate";
        imageOperation.actionParam = String.valueOf(i);
        return imageOperation;
    }

    @Override // com.baidu.tbadk.img.effect.b
    public void setParams(String str) {
        if (str != null) {
            this.aFB = Integer.parseInt(str);
        }
    }

    @Override // com.baidu.tbadk.img.effect.b
    public Bitmap b(Bitmap bitmap, boolean z) throws Exception {
        if (bitmap == null) {
            return null;
        }
        com.baidu.tbadk.imageManager.c.DT().fh(BitmapHelper.getBitmapSize(bitmap) * 2);
        if (this.aFB == 0 || this.aFB == 1) {
            return BitmapHelper.rotateBitmap(bitmap, this.aFB);
        }
        if (this.aFB == 2 || this.aFB == 3) {
            return BitmapHelper.reversalBitmap(bitmap, this.aFB);
        }
        return bitmap;
    }

    @Override // com.baidu.tbadk.img.effect.b
    public Bitmap gn(String str) throws Exception {
        int max = Math.max(l.ad(TbadkCoreApplication.getInst().getApp()), l.af(TbadkCoreApplication.getInst().getApp()));
        return b(BitmapHelper.loadResizedBitmap(str, max, max), true);
    }
}
