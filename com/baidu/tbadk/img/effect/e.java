package com.baidu.tbadk.img.effect;

import android.graphics.Bitmap;
import com.baidu.adp.lib.util.n;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class e extends b {
    private int alv = 0;

    @Override // com.baidu.tbadk.img.effect.b
    public String getActionName() {
        return "rotate";
    }

    public static ImageOperation dG(int i) {
        ImageOperation imageOperation = new ImageOperation();
        imageOperation.actionName = "rotate";
        imageOperation.actionParam = String.valueOf(i);
        return imageOperation;
    }

    @Override // com.baidu.tbadk.img.effect.b
    public void eu(String str) {
        if (str != null) {
            this.alv = Integer.parseInt(str);
        }
    }

    @Override // com.baidu.tbadk.img.effect.b
    public Bitmap b(Bitmap bitmap, boolean z) {
        if (bitmap == null) {
            return null;
        }
        com.baidu.tbadk.imageManager.e.zs().dE(com.baidu.tbadk.core.util.c.d(bitmap) * 2);
        if (this.alv == 0 || this.alv == 1) {
            return com.baidu.tbadk.core.util.c.g(bitmap, this.alv);
        }
        if (this.alv == 2 || this.alv == 3) {
            return com.baidu.tbadk.core.util.c.i(bitmap, this.alv);
        }
        return bitmap;
    }

    @Override // com.baidu.tbadk.img.effect.b
    public Bitmap ev(String str) {
        int max = Math.max(n.M(TbadkCoreApplication.m411getInst().getApp()), n.N(TbadkCoreApplication.m411getInst().getApp()));
        return b(com.baidu.tbadk.core.util.c.b(str, max, max), true);
    }
}
