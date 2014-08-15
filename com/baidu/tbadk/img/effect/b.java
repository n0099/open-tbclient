package com.baidu.tbadk.img.effect;

import android.graphics.Bitmap;
/* loaded from: classes.dex */
public abstract class b {
    public abstract Bitmap a(Bitmap bitmap, boolean z);

    public abstract String a();

    public abstract void b(String str);

    public Bitmap c(String str) {
        return a(com.baidu.tbadk.core.util.d.a(str), true);
    }
}
