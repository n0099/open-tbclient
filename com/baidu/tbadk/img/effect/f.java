package com.baidu.tbadk.img.effect;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.util.g;
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
            this.a = com.baidu.adp.lib.f.b.a(str, 0.0f);
        }
    }

    @Override // com.baidu.tbadk.img.effect.b
    public Bitmap a(Bitmap bitmap, boolean z) {
        if (bitmap == null) {
            return null;
        }
        if (this.a > 0.0f) {
            com.baidu.tbadk.imageManager.e.a().c(g.a(bitmap) * 2);
            return g.a(bitmap, this.a, z);
        }
        return bitmap;
    }
}
