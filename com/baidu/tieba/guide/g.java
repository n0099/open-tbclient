package com.baidu.tieba.guide;

import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
/* loaded from: classes.dex */
public abstract class g extends Drawable {
    public abstract void a();

    public abstract void a(int i, float f, int i2);

    public abstract boolean b();

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public void c() {
    }
}
