package com.baidu.tbadk.img.effect;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.util.BitmapHelper;
/* loaded from: classes.dex */
public class f extends b {
    private float aQj;

    @Override // com.baidu.tbadk.img.effect.b
    public String getActionName() {
        return "round_corner";
    }

    @Override // com.baidu.tbadk.img.effect.b
    public void setParams(String str) {
        if (str != null) {
            this.aQj = com.baidu.adp.lib.g.b.c(str, 0.0f);
        }
    }

    @Override // com.baidu.tbadk.img.effect.b
    public Bitmap b(Bitmap bitmap, boolean z) throws Exception {
        if (bitmap == null) {
            return null;
        }
        if (this.aQj > 0.0f) {
            com.baidu.tbadk.imageManager.c.ID().fc(BitmapHelper.getBitmapSize(bitmap) * 2);
            return BitmapHelper.getRoundedCornerBitmap(bitmap, this.aQj, z);
        }
        return bitmap;
    }
}
