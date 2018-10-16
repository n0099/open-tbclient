package com.baidu.tbadk.img.effect;

import android.graphics.Bitmap;
import com.baidu.adp.lib.util.l;
import com.baidu.searchbox.ng.ai.apps.canvas.action.draw.DaRotate;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
/* loaded from: classes.dex */
public class e extends b {
    private int aYS = 0;

    @Override // com.baidu.tbadk.img.effect.b
    public String getActionName() {
        return DaRotate.ACTION_TYPE;
    }

    public static ImageOperation fz(int i) {
        ImageOperation imageOperation = new ImageOperation();
        imageOperation.actionName = DaRotate.ACTION_TYPE;
        imageOperation.actionParam = String.valueOf(i);
        return imageOperation;
    }

    @Override // com.baidu.tbadk.img.effect.b
    public void setParams(String str) {
        if (str != null) {
            this.aYS = Integer.parseInt(str);
        }
    }

    @Override // com.baidu.tbadk.img.effect.b
    public Bitmap b(Bitmap bitmap, boolean z) throws Exception {
        if (bitmap == null) {
            return null;
        }
        com.baidu.tbadk.imageManager.c.Me().fy(BitmapHelper.getBitmapSize(bitmap) * 2);
        if (this.aYS == 0 || this.aYS == 1) {
            return BitmapHelper.rotateBitmap(bitmap, this.aYS);
        }
        if (this.aYS == 2 || this.aYS == 3) {
            return BitmapHelper.reversalBitmap(bitmap, this.aYS);
        }
        return bitmap;
    }

    @Override // com.baidu.tbadk.img.effect.b
    public Bitmap hT(String str) throws Exception {
        int max = Math.max(l.aO(TbadkCoreApplication.getInst().getApp()), l.aQ(TbadkCoreApplication.getInst().getApp()));
        return b(BitmapHelper.loadResizedBitmap(str, max, max), true);
    }
}
