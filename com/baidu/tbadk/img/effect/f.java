package com.baidu.tbadk.img.effect;

import android.graphics.Bitmap;
/* loaded from: classes.dex */
public class f extends b {
    private float abx;

    @Override // com.baidu.tbadk.img.effect.b
    public String getActionName() {
        return "round_corner";
    }

    @Override // com.baidu.tbadk.img.effect.b
    public void eq(String str) {
        if (str != null) {
            this.abx = com.baidu.adp.lib.g.c.a(str, 0.0f);
        }
    }

    @Override // com.baidu.tbadk.img.effect.b
    public Bitmap b(Bitmap bitmap, boolean z) {
        if (bitmap == null) {
            return null;
        }
        if (this.abx > 0.0f) {
            com.baidu.tbadk.imageManager.e.vL().dq(com.baidu.tbadk.core.util.d.d(bitmap) * 2);
            return com.baidu.tbadk.core.util.d.a(bitmap, this.abx, z);
        }
        return bitmap;
    }
}
