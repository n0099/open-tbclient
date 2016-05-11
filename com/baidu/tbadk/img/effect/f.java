package com.baidu.tbadk.img.effect;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.util.BitmapHelper;
/* loaded from: classes.dex */
public class f extends b {
    private float auo;

    @Override // com.baidu.tbadk.img.effect.b
    public String getActionName() {
        return "round_corner";
    }

    @Override // com.baidu.tbadk.img.effect.b
    public void setParams(String str) {
        if (str != null) {
            this.auo = com.baidu.adp.lib.h.b.a(str, 0.0f);
        }
    }

    @Override // com.baidu.tbadk.img.effect.b
    public Bitmap b(Bitmap bitmap, boolean z) {
        if (bitmap == null) {
            return null;
        }
        if (this.auo > 0.0f) {
            com.baidu.tbadk.imageManager.c.CH().ez(BitmapHelper.getBitmapSize(bitmap) * 2);
            return BitmapHelper.getRoundedCornerBitmap(bitmap, this.auo, z);
        }
        return bitmap;
    }
}
