package com.baidu.tbadk.img.effect;

import android.graphics.Bitmap;
import com.baidu.tbadk.core.util.g;
/* loaded from: classes.dex */
public class d extends b {
    private int a;
    private int b;

    @Override // com.baidu.tbadk.img.effect.b
    public String a() {
        return "resize";
    }

    public static ImageOperation a(int i, int i2) {
        ImageOperation imageOperation = new ImageOperation();
        imageOperation.actionName = "resize";
        imageOperation.actionParam = String.valueOf(i) + "," + i2;
        return imageOperation;
    }

    @Override // com.baidu.tbadk.img.effect.b
    public void b(String str) {
        if (str != null) {
            String[] split = str.split(",");
            if (split.length == 2) {
                this.a = com.baidu.adp.lib.f.b.a(split[0], 0);
                this.b = com.baidu.adp.lib.f.b.a(split[1], 0);
            }
        }
    }

    @Override // com.baidu.tbadk.img.effect.b
    public Bitmap a(Bitmap bitmap, boolean z) {
        if (bitmap == null) {
            return null;
        }
        com.baidu.tbadk.imageManager.e.a().c(g.a(bitmap) * 2);
        return g.a(bitmap, this.a, this.b, z);
    }

    @Override // com.baidu.tbadk.img.effect.b
    public Bitmap c(String str) {
        return a(g.a(str, this.a, this.b), true);
    }

    public int b() {
        return this.a;
    }

    public int c() {
        return this.b;
    }
}
