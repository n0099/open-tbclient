package com.baidu.tbadk.img.effect;

import android.graphics.Bitmap;
import com.baidu.adp.lib.util.l;
import com.baidu.searchbox.ng.ai.apps.canvas.action.draw.DaRotate;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
/* loaded from: classes.dex */
public class e extends b {
    private int bdh = 0;

    @Override // com.baidu.tbadk.img.effect.b
    public String getActionName() {
        return DaRotate.ACTION_TYPE;
    }

    public static ImageOperation gc(int i) {
        ImageOperation imageOperation = new ImageOperation();
        imageOperation.actionName = DaRotate.ACTION_TYPE;
        imageOperation.actionParam = String.valueOf(i);
        return imageOperation;
    }

    @Override // com.baidu.tbadk.img.effect.b
    public void setParams(String str) {
        if (str != null) {
            this.bdh = Integer.parseInt(str);
        }
    }

    @Override // com.baidu.tbadk.img.effect.b
    public Bitmap b(Bitmap bitmap, boolean z) throws Exception {
        if (bitmap == null) {
            return null;
        }
        com.baidu.tbadk.imageManager.c.Nv().gb(BitmapHelper.getBitmapSize(bitmap) * 2);
        if (this.bdh == 0 || this.bdh == 1) {
            return BitmapHelper.rotateBitmap(bitmap, this.bdh);
        }
        if (this.bdh == 2 || this.bdh == 3) {
            return BitmapHelper.reversalBitmap(bitmap, this.bdh);
        }
        return bitmap;
    }

    @Override // com.baidu.tbadk.img.effect.b
    public Bitmap in(String str) throws Exception {
        int max = Math.max(l.aO(TbadkCoreApplication.getInst().getApp()), l.aQ(TbadkCoreApplication.getInst().getApp()));
        return b(BitmapHelper.loadResizedBitmap(str, max, max), true);
    }
}
