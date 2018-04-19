package com.baidu.tbadk.img.effect;

import android.graphics.Bitmap;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
/* loaded from: classes.dex */
public class e extends b {
    private int aHK = 0;

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
            this.aHK = Integer.parseInt(str);
        }
    }

    @Override // com.baidu.tbadk.img.effect.b
    public Bitmap b(Bitmap bitmap, boolean z) throws Exception {
        if (bitmap == null) {
            return null;
        }
        com.baidu.tbadk.imageManager.c.Fa().eX(BitmapHelper.getBitmapSize(bitmap) * 2);
        if (this.aHK == 0 || this.aHK == 1) {
            return BitmapHelper.rotateBitmap(bitmap, this.aHK);
        }
        if (this.aHK == 2 || this.aHK == 3) {
            return BitmapHelper.reversalBitmap(bitmap, this.aHK);
        }
        return bitmap;
    }

    @Override // com.baidu.tbadk.img.effect.b
    public Bitmap gL(String str) throws Exception {
        int max = Math.max(l.af(TbadkCoreApplication.getInst().getApp()), l.ah(TbadkCoreApplication.getInst().getApp()));
        return b(BitmapHelper.loadResizedBitmap(str, max, max), true);
    }
}
