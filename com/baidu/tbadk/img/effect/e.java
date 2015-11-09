package com.baidu.tbadk.img.effect;

import android.graphics.Bitmap;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class e extends b {
    private int atg = 0;

    @Override // com.baidu.tbadk.img.effect.b
    public String getActionName() {
        return "rotate";
    }

    public static ImageOperation em(int i) {
        ImageOperation imageOperation = new ImageOperation();
        imageOperation.actionName = "rotate";
        imageOperation.actionParam = String.valueOf(i);
        return imageOperation;
    }

    @Override // com.baidu.tbadk.img.effect.b
    public void ft(String str) {
        if (str != null) {
            this.atg = Integer.parseInt(str);
        }
    }

    @Override // com.baidu.tbadk.img.effect.b
    public Bitmap b(Bitmap bitmap, boolean z) {
        if (bitmap == null) {
            return null;
        }
        com.baidu.tbadk.imageManager.c.BV().el(com.baidu.tbadk.core.util.c.f(bitmap) * 2);
        if (this.atg == 0 || this.atg == 1) {
            return com.baidu.tbadk.core.util.c.h(bitmap, this.atg);
        }
        if (this.atg == 2 || this.atg == 3) {
            return com.baidu.tbadk.core.util.c.j(bitmap, this.atg);
        }
        return bitmap;
    }

    @Override // com.baidu.tbadk.img.effect.b
    public Bitmap fu(String str) {
        int max = Math.max(k.K(TbadkCoreApplication.m411getInst().getApp()), k.L(TbadkCoreApplication.m411getInst().getApp()));
        return b(com.baidu.tbadk.core.util.c.b(str, max, max), true);
    }
}
