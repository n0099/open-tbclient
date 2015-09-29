package com.baidu.tbadk.img.effect;

import android.graphics.Bitmap;
/* loaded from: classes.dex */
public class f extends b {
    private float aus;

    @Override // com.baidu.tbadk.img.effect.b
    public String getActionName() {
        return "round_corner";
    }

    @Override // com.baidu.tbadk.img.effect.b
    public void fr(String str) {
        if (str != null) {
            this.aus = com.baidu.adp.lib.g.b.a(str, 0.0f);
        }
    }

    @Override // com.baidu.tbadk.img.effect.b
    public Bitmap b(Bitmap bitmap, boolean z) {
        if (bitmap == null) {
            return null;
        }
        if (this.aus > 0.0f) {
            com.baidu.tbadk.imageManager.c.Cf().en(com.baidu.tbadk.core.util.c.f(bitmap) * 2);
            return com.baidu.tbadk.core.util.c.a(bitmap, this.aus, z);
        }
        return bitmap;
    }
}
