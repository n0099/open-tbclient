package com.baidu.tbadk.img.effect;

import android.graphics.Bitmap;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.img.effect.RotateImageAction;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
/* loaded from: classes.dex */
public class e extends b {
    private int rotateType = 0;

    @Override // com.baidu.tbadk.img.effect.b
    public String getActionName() {
        return RotateImageAction.ACTION_NAME;
    }

    public static ImageOperation mP(int i) {
        ImageOperation imageOperation = new ImageOperation();
        imageOperation.actionName = RotateImageAction.ACTION_NAME;
        imageOperation.actionParam = String.valueOf(i);
        return imageOperation;
    }

    @Override // com.baidu.tbadk.img.effect.b
    public void setParams(String str) {
        if (str != null) {
            this.rotateType = Integer.parseInt(str);
        }
    }

    @Override // com.baidu.tbadk.img.effect.b
    public Bitmap processImage(Bitmap bitmap, boolean z) throws Exception {
        if (bitmap == null) {
            return null;
        }
        com.baidu.tbadk.imageManager.c.aYk().freePicCache(BitmapHelper.getBitmapSize(bitmap) * 2);
        if (this.rotateType == 0 || this.rotateType == 1) {
            return BitmapHelper.rotateBitmap(bitmap, this.rotateType);
        }
        if (this.rotateType == 2 || this.rotateType == 3) {
            return BitmapHelper.reversalBitmap(bitmap, this.rotateType);
        }
        return bitmap;
    }

    @Override // com.baidu.tbadk.img.effect.b
    public Bitmap processImage(String str) throws Exception {
        int max = Math.max(l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp()), l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp()));
        return processImage(BitmapHelper.loadResizedBitmap(str, max, max), true);
    }
}
