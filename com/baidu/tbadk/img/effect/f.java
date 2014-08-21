package com.baidu.tbadk.img.effect;

import android.graphics.Bitmap;
/* loaded from: classes.dex */
public class f extends b {
    private float a;

    @Override // com.baidu.tbadk.img.effect.b
    public String a() {
        return "round_corner";
    }

    @Override // com.baidu.tbadk.img.effect.b
    public void b(String str) {
        if (str != null) {
            this.a = com.baidu.adp.lib.e.c.a(str, 0.0f);
        }
    }

    @Override // com.baidu.tbadk.img.effect.b
    public Bitmap a(Bitmap bitmap, boolean z) {
        if (bitmap == null) {
            return null;
        }
        if (this.a > 0.0f) {
            com.baidu.tbadk.imageManager.e.a().c(com.baidu.tbadk.core.util.d.a(bitmap) * 2);
            return com.baidu.tbadk.core.util.d.a(bitmap, this.a, z);
        }
        return bitmap;
    }
}
