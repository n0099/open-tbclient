package com.baidu.tbadk.img.effect;

import android.graphics.Bitmap;
/* loaded from: classes.dex */
public class f extends b {
    private float ath;

    @Override // com.baidu.tbadk.img.effect.b
    public String getActionName() {
        return "round_corner";
    }

    @Override // com.baidu.tbadk.img.effect.b
    public void ft(String str) {
        if (str != null) {
            this.ath = com.baidu.adp.lib.g.b.a(str, 0.0f);
        }
    }

    @Override // com.baidu.tbadk.img.effect.b
    public Bitmap b(Bitmap bitmap, boolean z) {
        if (bitmap == null) {
            return null;
        }
        if (this.ath > 0.0f) {
            com.baidu.tbadk.imageManager.c.BV().el(com.baidu.tbadk.core.util.c.f(bitmap) * 2);
            return com.baidu.tbadk.core.util.c.a(bitmap, this.ath, z);
        }
        return bitmap;
    }
}
