package com.baidu.tbadk.img.effect;

import android.graphics.Bitmap;
/* loaded from: classes.dex */
public class f extends b {
    private float amF;

    @Override // com.baidu.tbadk.img.effect.b
    public String getActionName() {
        return "round_corner";
    }

    @Override // com.baidu.tbadk.img.effect.b
    public void eO(String str) {
        if (str != null) {
            this.amF = com.baidu.adp.lib.g.c.a(str, 0.0f);
        }
    }

    @Override // com.baidu.tbadk.img.effect.b
    public Bitmap b(Bitmap bitmap, boolean z) {
        if (bitmap == null) {
            return null;
        }
        if (this.amF > 0.0f) {
            com.baidu.tbadk.imageManager.e.Am().dN(com.baidu.tbadk.core.util.c.d(bitmap) * 2);
            return com.baidu.tbadk.core.util.c.a(bitmap, this.amF, z);
        }
        return bitmap;
    }
}
