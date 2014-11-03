package com.baidu.tbadk.img.effect;

import android.graphics.Bitmap;
/* loaded from: classes.dex */
public class f extends b {
    private float Vt;

    @Override // com.baidu.tbadk.img.effect.b
    public String sr() {
        return "round_corner";
    }

    @Override // com.baidu.tbadk.img.effect.b
    public void dw(String str) {
        if (str != null) {
            this.Vt = com.baidu.adp.lib.g.c.a(str, 0.0f);
        }
    }

    @Override // com.baidu.tbadk.img.effect.b
    public Bitmap b(Bitmap bitmap, boolean z) {
        if (bitmap == null) {
            return null;
        }
        if (this.Vt > 0.0f) {
            com.baidu.tbadk.imageManager.e.si().cR(com.baidu.tbadk.core.util.d.a(bitmap) * 2);
            return com.baidu.tbadk.core.util.d.a(bitmap, this.Vt, z);
        }
        return bitmap;
    }
}
