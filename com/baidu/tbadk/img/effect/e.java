package com.baidu.tbadk.img.effect;

import android.graphics.Bitmap;
import com.baidu.adp.lib.util.m;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public class e extends b {
    private int Vs = 0;

    @Override // com.baidu.tbadk.img.effect.b
    public String sr() {
        return "rotate";
    }

    public static ImageOperation cT(int i) {
        ImageOperation imageOperation = new ImageOperation();
        imageOperation.actionName = "rotate";
        imageOperation.actionParam = String.valueOf(i);
        return imageOperation;
    }

    @Override // com.baidu.tbadk.img.effect.b
    public void dw(String str) {
        if (str != null) {
            this.Vs = Integer.parseInt(str);
        }
    }

    @Override // com.baidu.tbadk.img.effect.b
    public Bitmap b(Bitmap bitmap, boolean z) {
        if (bitmap == null) {
            return null;
        }
        com.baidu.tbadk.imageManager.e.si().cR(com.baidu.tbadk.core.util.d.a(bitmap) * 2);
        if (this.Vs == 0 || this.Vs == 1) {
            return com.baidu.tbadk.core.util.d.d(bitmap, this.Vs);
        }
        if (this.Vs == 2 || this.Vs == 3) {
            return com.baidu.tbadk.core.util.d.f(bitmap, this.Vs);
        }
        return bitmap;
    }

    @Override // com.baidu.tbadk.img.effect.b
    public Bitmap dx(String str) {
        int max = Math.max(m.n(TbadkApplication.m251getInst().getApp()), m.o(TbadkApplication.m251getInst().getApp()));
        return b(com.baidu.tbadk.core.util.d.a(str, max, max), true);
    }
}
