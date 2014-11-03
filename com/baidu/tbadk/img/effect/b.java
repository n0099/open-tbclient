package com.baidu.tbadk.img.effect;

import android.graphics.Bitmap;
/* loaded from: classes.dex */
public abstract class b {
    public abstract Bitmap b(Bitmap bitmap, boolean z);

    public abstract void dw(String str);

    public abstract String sr();

    public Bitmap dx(String str) {
        return b(com.baidu.tbadk.core.util.d.bk(str), true);
    }
}
