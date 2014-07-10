package com.baidu.tbadk.img.effect;

import android.graphics.Bitmap;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.h;
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
        com.baidu.tbadk.imageManager.e.a().c(h.a(bitmap) * 2);
        if (this.a == 0 || this.a == 1) {
            return h.d(bitmap, this.a);
        }
        if (this.a == 2 || this.a == 3) {
            return h.f(bitmap, this.a);
        }
        return bitmap;
    }

    @Override // com.baidu.tbadk.img.effect.b
    public Bitmap c(String str) {
        int max = Math.max(j.b(TbadkApplication.m252getInst().getApp()), j.c(TbadkApplication.m252getInst().getApp()));
        return a(h.a(str, max, max), true);
    }
}
