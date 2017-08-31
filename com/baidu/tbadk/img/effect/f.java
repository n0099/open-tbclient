package com.baidu.tbadk.img.effect;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.util.BitmapHelper;
/* loaded from: classes.dex */
public class f extends b {
    private float aGr;

    @Override // com.baidu.tbadk.img.effect.b
    public String getActionName() {
        return "round_corner";
    }

    @Override // com.baidu.tbadk.img.effect.b
    public void setParams(String str) {
        if (str != null) {
            this.aGr = com.baidu.adp.lib.g.b.a(str, 0.0f);
        }
    }

    @Override // com.baidu.tbadk.img.effect.b
    public Bitmap b(Bitmap bitmap, boolean z) throws Exception {
        if (bitmap == null) {
            return null;
        }
        if (this.aGr > 0.0f) {
            com.baidu.tbadk.imageManager.c.Ev().eX(BitmapHelper.getBitmapSize(bitmap) * 2);
            return BitmapHelper.getRoundedCornerBitmap(bitmap, this.aGr, z);
        }
        return bitmap;
    }
}
