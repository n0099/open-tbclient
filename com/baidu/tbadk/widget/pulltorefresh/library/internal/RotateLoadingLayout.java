package com.baidu.tbadk.widget.pulltorefresh.library.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import com.baidu.tbadk.widget.pulltorefresh.library.PullToRefreshBase;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class RotateLoadingLayout extends LoadingLayout {
    private final Animation bdZ;
    private final Matrix ben;
    private float beo;
    private float bep;
    private final boolean beq;

    public RotateLoadingLayout(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation orientation, TypedArray typedArray) {
        super(context, mode, orientation, typedArray);
        this.beq = typedArray.getBoolean(d.m.PullToRefresh_tb_ptrRotateDrawableWhilePulling, true);
        this.bed.setScaleType(ImageView.ScaleType.MATRIX);
        this.ben = new Matrix();
        this.bed.setImageMatrix(this.ben);
        this.bdZ = new RotateAnimation(0.0f, 720.0f, 1, 0.5f, 1, 0.5f);
        this.bdZ.setInterpolator(beb);
        this.bdZ.setDuration(1200L);
        this.bdZ.setRepeatCount(-1);
        this.bdZ.setRepeatMode(1);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.internal.LoadingLayout
    public void f(Drawable drawable) {
        if (drawable != null) {
            this.beo = Math.round(drawable.getIntrinsicWidth() / 2.0f);
            this.bep = Math.round(drawable.getIntrinsicHeight() / 2.0f);
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.internal.LoadingLayout
    protected void ac(float f) {
        float max;
        if (this.beq) {
            max = 90.0f * f;
        } else {
            max = Math.max(0.0f, Math.min(180.0f, (360.0f * f) - 180.0f));
        }
        this.ben.setRotate(max, this.beo, this.bep);
        this.bed.setImageMatrix(this.ben);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.internal.LoadingLayout
    protected void Nv() {
        this.bed.startAnimation(this.bdZ);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.internal.LoadingLayout
    protected void Nx() {
        this.bed.clearAnimation();
        Ny();
    }

    private void Ny() {
        if (this.ben != null) {
            this.ben.reset();
            this.bed.setImageMatrix(this.ben);
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.internal.LoadingLayout
    protected void Nu() {
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.internal.LoadingLayout
    protected void Nw() {
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.internal.LoadingLayout
    protected int getDefaultDrawableResId() {
        return d.f.default_ptr_rotate;
    }
}
