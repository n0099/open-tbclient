package com.baidu.tbadk.img.effect;

import android.graphics.Bitmap;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class e extends b {
    private int abw = 0;

    @Override // com.baidu.tbadk.img.effect.b
    public String getActionName() {
        return "rotate";
    }

    public static ImageOperation ds(int i) {
        ImageOperation imageOperation = new ImageOperation();
        imageOperation.actionName = "rotate";
        imageOperation.actionParam = String.valueOf(i);
        return imageOperation;
    }

    @Override // com.baidu.tbadk.img.effect.b
    public void eq(String str) {
        if (str != null) {
            this.abw = Integer.parseInt(str);
        }
    }

    @Override // com.baidu.tbadk.img.effect.b
    public Bitmap b(Bitmap bitmap, boolean z) {
        if (bitmap == null) {
            return null;
        }
        com.baidu.tbadk.imageManager.e.vL().dq(com.baidu.tbadk.core.util.d.d(bitmap) * 2);
        if (this.abw == 0 || this.abw == 1) {
            return com.baidu.tbadk.core.util.d.g(bitmap, this.abw);
        }
        if (this.abw == 2 || this.abw == 3) {
            return com.baidu.tbadk.core.util.d.i(bitmap, this.abw);
        }
        return bitmap;
    }

    @Override // com.baidu.tbadk.img.effect.b
    public Bitmap er(String str) {
        int max = Math.max(l.M(TbadkCoreApplication.m255getInst().getApp()), l.N(TbadkCoreApplication.m255getInst().getApp()));
        return b(com.baidu.tbadk.core.util.d.b(str, max, max), true);
    }
}
