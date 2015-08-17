package com.baidu.tbadk.img.effect;

import android.graphics.Bitmap;
/* loaded from: classes.dex */
public class f extends b {
    private float aul;

    @Override // com.baidu.tbadk.img.effect.b
    public String getActionName() {
        return "round_corner";
    }

    @Override // com.baidu.tbadk.img.effect.b
    public void fe(String str) {
        if (str != null) {
            this.aul = com.baidu.adp.lib.g.b.a(str, 0.0f);
        }
    }

    @Override // com.baidu.tbadk.img.effect.b
    public Bitmap b(Bitmap bitmap, boolean z) {
        if (bitmap == null) {
            return null;
        }
        if (this.aul > 0.0f) {
            com.baidu.tbadk.imageManager.c.Ce().ee(com.baidu.tbadk.core.util.c.f(bitmap) * 2);
            return com.baidu.tbadk.core.util.c.a(bitmap, this.aul, z);
        }
        return bitmap;
    }
}
