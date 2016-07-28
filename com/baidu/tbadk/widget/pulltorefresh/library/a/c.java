package com.baidu.tbadk.widget.pulltorefresh.library.a;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import com.baidu.tbadk.widget.pulltorefresh.library.PullToRefreshBase;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class c extends b {
    private final Animation aEK;
    private final Matrix aEX;
    private float aEY;
    private float aEZ;
    private final boolean aFa;

    public c(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation orientation, TypedArray typedArray) {
        super(context, mode, orientation, typedArray);
        this.aFa = typedArray.getBoolean(15, true);
        this.aEO.setScaleType(ImageView.ScaleType.MATRIX);
        this.aEX = new Matrix();
        this.aEO.setImageMatrix(this.aEX);
        this.aEK = new RotateAnimation(0.0f, 720.0f, 1, 0.5f, 1, 0.5f);
        this.aEK.setInterpolator(aEM);
        this.aEK.setDuration(1200L);
        this.aEK.setRepeatCount(-1);
        this.aEK.setRepeatMode(1);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    public void f(Drawable drawable) {
        if (drawable != null) {
            this.aEY = Math.round(drawable.getIntrinsicWidth() / 2.0f);
            this.aEZ = Math.round(drawable.getIntrinsicHeight() / 2.0f);
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void D(float f) {
        float max;
        if (this.aFa) {
            max = 90.0f * f;
        } else {
            max = Math.max(0.0f, Math.min(180.0f, (360.0f * f) - 180.0f));
        }
        this.aEX.setRotate(max, this.aEY, this.aEZ);
        this.aEO.setImageMatrix(this.aEX);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Gy() {
        this.aEO.startAnimation(this.aEK);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void GA() {
        this.aEO.clearAnimation();
        GB();
    }

    private void GB() {
        if (this.aEX != null) {
            this.aEX.reset();
            this.aEO.setImageMatrix(this.aEX);
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Gx() {
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected void Gz() {
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.a.b
    protected int getDefaultDrawableResId() {
        return u.f.default_ptr_rotate;
    }
}
