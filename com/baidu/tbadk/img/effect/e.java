package com.baidu.tbadk.img.effect;

import android.graphics.Bitmap;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class e extends b {
    private int abY = 0;

    @Override // com.baidu.tbadk.img.effect.b
    public String getActionName() {
        return "rotate";
    }

    public static ImageOperation dz(int i) {
        ImageOperation imageOperation = new ImageOperation();
        imageOperation.actionName = "rotate";
        imageOperation.actionParam = String.valueOf(i);
        return imageOperation;
    }

    @Override // com.baidu.tbadk.img.effect.b
    public void eq(String str) {
        if (str != null) {
            this.abY = Integer.parseInt(str);
        }
    }

    @Override // com.baidu.tbadk.img.effect.b
    public Bitmap b(Bitmap bitmap, boolean z) {
        if (bitmap == null) {
            return null;
        }
        com.baidu.tbadk.imageManager.e.we().dx(com.baidu.tbadk.core.util.d.d(bitmap) * 2);
        if (this.abY == 0 || this.abY == 1) {
            return com.baidu.tbadk.core.util.d.g(bitmap, this.abY);
        }
        if (this.abY == 2 || this.abY == 3) {
            return com.baidu.tbadk.core.util.d.i(bitmap, this.abY);
        }
        return bitmap;
    }

    @Override // com.baidu.tbadk.img.effect.b
    public Bitmap er(String str) {
        int max = Math.max(l.M(TbadkCoreApplication.m255getInst().getApp()), l.N(TbadkCoreApplication.m255getInst().getApp()));
        return b(com.baidu.tbadk.core.util.d.b(str, max, max), true);
    }
}
