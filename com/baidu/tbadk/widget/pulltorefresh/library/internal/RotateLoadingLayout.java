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
    private final boolean beA;
    private final Animation bej;
    private final Matrix bex;
    private float bey;
    private float bez;

    public RotateLoadingLayout(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation orientation, TypedArray typedArray) {
        super(context, mode, orientation, typedArray);
        this.beA = typedArray.getBoolean(d.l.PullToRefresh_tb_ptrRotateDrawableWhilePulling, true);
        this.ben.setScaleType(ImageView.ScaleType.MATRIX);
        this.bex = new Matrix();
        this.ben.setImageMatrix(this.bex);
        this.bej = new RotateAnimation(0.0f, 720.0f, 1, 0.5f, 1, 0.5f);
        this.bej.setInterpolator(bel);
        this.bej.setDuration(1200L);
        this.bej.setRepeatCount(-1);
        this.bej.setRepeatMode(1);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.internal.LoadingLayout
    public void f(Drawable drawable) {
        if (drawable != null) {
            this.bey = Math.round(drawable.getIntrinsicWidth() / 2.0f);
            this.bez = Math.round(drawable.getIntrinsicHeight() / 2.0f);
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.internal.LoadingLayout
    protected void ad(float f) {
        float max;
        if (this.beA) {
            max = 90.0f * f;
        } else {
            max = Math.max(0.0f, Math.min(180.0f, (360.0f * f) - 180.0f));
        }
        this.bex.setRotate(max, this.bey, this.bez);
        this.ben.setImageMatrix(this.bex);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.internal.LoadingLayout
    protected void Ns() {
        this.ben.startAnimation(this.bej);
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.internal.LoadingLayout
    protected void Nu() {
        this.ben.clearAnimation();
        Nv();
    }

    private void Nv() {
        if (this.bex != null) {
            this.bex.reset();
            this.ben.setImageMatrix(this.bex);
        }
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.internal.LoadingLayout
    protected void Nr() {
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.internal.LoadingLayout
    protected void Nt() {
    }

    @Override // com.baidu.tbadk.widget.pulltorefresh.library.internal.LoadingLayout
    protected int getDefaultDrawableResId() {
        return d.f.default_ptr_rotate;
    }
}
