package com.baidu.tbadk.img.effect;

import android.graphics.Bitmap;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class e extends b {
    private int aur = 0;

    @Override // com.baidu.tbadk.img.effect.b
    public String getActionName() {
        return "rotate";
    }

    public static ImageOperation eo(int i) {
        ImageOperation imageOperation = new ImageOperation();
        imageOperation.actionName = "rotate";
        imageOperation.actionParam = String.valueOf(i);
        return imageOperation;
    }

    @Override // com.baidu.tbadk.img.effect.b
    public void fr(String str) {
        if (str != null) {
            this.aur = Integer.parseInt(str);
        }
    }

    @Override // com.baidu.tbadk.img.effect.b
    public Bitmap b(Bitmap bitmap, boolean z) {
        if (bitmap == null) {
            return null;
        }
        com.baidu.tbadk.imageManager.c.Cf().en(com.baidu.tbadk.core.util.c.f(bitmap) * 2);
        if (this.aur == 0 || this.aur == 1) {
            return com.baidu.tbadk.core.util.c.h(bitmap, this.aur);
        }
        if (this.aur == 2 || this.aur == 3) {
            return com.baidu.tbadk.core.util.c.j(bitmap, this.aur);
        }
        return bitmap;
    }

    @Override // com.baidu.tbadk.img.effect.b
    public Bitmap fs(String str) {
        int max = Math.max(k.K(TbadkCoreApplication.m411getInst().getApp()), k.L(TbadkCoreApplication.m411getInst().getApp()));
        return b(com.baidu.tbadk.core.util.c.b(str, max, max), true);
    }
}
