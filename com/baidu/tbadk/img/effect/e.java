package com.baidu.tbadk.img.effect;

import android.graphics.Bitmap;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class e extends b {
    private int avk = 0;

    @Override // com.baidu.tbadk.img.effect.b
    public String getActionName() {
        return "rotate";
    }

    public static ImageOperation eA(int i) {
        ImageOperation imageOperation = new ImageOperation();
        imageOperation.actionName = "rotate";
        imageOperation.actionParam = String.valueOf(i);
        return imageOperation;
    }

    @Override // com.baidu.tbadk.img.effect.b
    public void fH(String str) {
        if (str != null) {
            this.avk = Integer.parseInt(str);
        }
    }

    @Override // com.baidu.tbadk.img.effect.b
    public Bitmap b(Bitmap bitmap, boolean z) {
        if (bitmap == null) {
            return null;
        }
        com.baidu.tbadk.imageManager.c.CX().ez(com.baidu.tbadk.core.util.c.f(bitmap) * 2);
        if (this.avk == 0 || this.avk == 1) {
            return com.baidu.tbadk.core.util.c.h(bitmap, this.avk);
        }
        if (this.avk == 2 || this.avk == 3) {
            return com.baidu.tbadk.core.util.c.j(bitmap, this.avk);
        }
        return bitmap;
    }

    @Override // com.baidu.tbadk.img.effect.b
    public Bitmap fI(String str) {
        int max = Math.max(k.K(TbadkCoreApplication.m411getInst().getApp()), k.L(TbadkCoreApplication.m411getInst().getApp()));
        return b(com.baidu.tbadk.core.util.c.b(str, max, max), true);
    }
}
