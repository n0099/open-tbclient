package com.baidu.tbadk.img.effect;

import android.graphics.Bitmap;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public class e extends b {
    private int a = 0;

    @Override // com.baidu.tbadk.img.effect.b
    public String a() {
        return "rotate";
    }

    public static ImageOperation a(int i) {
        ImageOperation imageOperation = new ImageOperation();
        imageOperation.actionName = "rotate";
        imageOperation.actionParam = String.valueOf(i);
        return imageOperation;
    }

    @Override // com.baidu.tbadk.img.effect.b
    public void b(String str) {
        if (str != null) {
            this.a = Integer.parseInt(str);
        }
    }

    @Override // com.baidu.tbadk.img.effect.b
    public Bitmap a(Bitmap bitmap, boolean z) {
        if (bitmap == null) {
            return null;
        }
        com.baidu.tbadk.imageManager.e.a().c(com.baidu.tbadk.core.util.d.a(bitmap) * 2);
        if (this.a == 0 || this.a == 1) {
            return com.baidu.tbadk.core.util.d.d(bitmap, this.a);
        }
        if (this.a == 2 || this.a == 3) {
            return com.baidu.tbadk.core.util.d.f(bitmap, this.a);
        }
        return bitmap;
    }

    @Override // com.baidu.tbadk.img.effect.b
    public Bitmap c(String str) {
        int max = Math.max(j.b(TbadkApplication.m252getInst().getApp()), j.c(TbadkApplication.m252getInst().getApp()));
        return a(com.baidu.tbadk.core.util.d.a(str, max, max), true);
    }
}
