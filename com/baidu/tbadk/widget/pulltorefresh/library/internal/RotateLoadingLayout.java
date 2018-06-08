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
    private final Animation bcL;
    private final Matrix bcY;
    private float bcZ;
    private float bda;
    private final boolean bdb;

    public RotateLoadingLayout(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation orientation, TypedArray typedArray) {
        super(context, mode, orientation, typedArray);
        this.bdb = typedArray.getBoolean(d.m.PullToRefresh_tb_ptrRotateDrawableWhilePulling, true);
        this.bcP.setScaleType(ImageView.ScaleType.MATRIX);
        this.bcY = new Matrix();
        this.bcP.setImageMatrix(this.bcY);
        this.bcL = new RotateAnimation(0.0f, 720.0f, 1, 0.5f, 1, 0.5f);
        this.bcL.setInterpolator(bcN);
        this.bcL.setDuration(1200L);
        this.bcL.setRepeatCount(-1);
        this.bcL.setRepeatMode(1);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.internal.LoadingLayout
    public void f(Drawable drawable) {
        if (drawable != null) {
            this.bcZ = Math.round(drawable.getIntrinsicWidth() / 2.0f);
            this.bda = Math.round(drawable.getIntrinsicHeight() / 2.0f);
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.internal.LoadingLayout
    protected void ac(float f) {
        float max;
        if (this.bdb) {
            max = 90.0f * f;
        } else {
            max = Math.max(0.0f, Math.min(180.0f, (360.0f * f) - 180.0f));
        }
        this.bcY.setRotate(max, this.bcZ, this.bda);
        this.bcP.setImageMatrix(this.bcY);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.internal.LoadingLayout
    protected void Nc() {
        this.bcP.startAnimation(this.bcL);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.internal.LoadingLayout
    protected void Ne() {
        this.bcP.clearAnimation();
        Nf();
    }

    private void Nf() {
        if (this.bcY != null) {
            this.bcY.reset();
            this.bcP.setImageMatrix(this.bcY);
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.internal.LoadingLayout
    protected void Nb() {
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.internal.LoadingLayout
    protected void Nd() {
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.internal.LoadingLayout
    protected int getDefaultDrawableResId() {
        return d.f.default_ptr_rotate;
    }
}
