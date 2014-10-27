package com.baidu.tbadk.img.effect;

import android.graphics.Bitmap;
import com.baidu.adp.lib.util.m;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public class e extends b {
    private int Vo = 0;

    @Override // com.baidu.tbadk.img.effect.b
    public String sp() {
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
            this.Vo = Integer.parseInt(str);
        }
    }

    @Override // com.baidu.tbadk.img.effect.b
    public Bitmap b(Bitmap bitmap, boolean z) {
        if (bitmap == null) {
            return null;
        }
        com.baidu.tbadk.imageManager.e.sg().cR(com.baidu.tbadk.core.util.d.a(bitmap) * 2);
        if (this.Vo == 0 || this.Vo == 1) {
            return com.baidu.tbadk.core.util.d.d(bitmap, this.Vo);
        }
        if (this.Vo == 2 || this.Vo == 3) {
            return com.baidu.tbadk.core.util.d.f(bitmap, this.Vo);
        }
        return bitmap;
    }

    @Override // com.baidu.tbadk.img.effect.b
    public Bitmap dx(String str) {
        int max = Math.max(m.n(TbadkApplication.m251getInst().getApp()), m.o(TbadkApplication.m251getInst().getApp()));
        return b(com.baidu.tbadk.core.util.d.a(str, max, max), true);
    }
}
